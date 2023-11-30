import pymssql
from flask import Flask, request, jsonify
import threading
from datetime import datetime, timedelta 
import time
import random

app = Flask(__name__)

def Connection():
    conn = pymssql.connect(host='localhost',
                       user='sungmin',
                       password='1234',
                       database='StudyCafe',
                      charset = 'utf8')
    return conn


@app.route('/membership', methods=['POST']) #회원가입 요청
def membership():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()

        if not data:
               return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
       
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "insert into Members(phone, pw, email,gender,birth) values (%s, %s, %s, %s, %s)"
        a = cursor.execute(sql, (data['phone'], data['pw'], data['email'], data['gender'], data['birth']))
        conn.commit()
        conn.close()
        if cursor.rowcount == 1: 
            data = {"check" : "true"}
            return data
        else :
            data = {"check" : "false"}
            return data
    except Exception as e:
          return jsonify({'message': 'Error occurred', 'error':str(e)}), 500

@app.route('/Login', methods=['POST']) #로그인 요청
def Login():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()
        if not data:
               return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
       
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "select phone, pw,seat_time from Members where phone = %s and pw = %s"
        cursor.execute(sql,(data['phone'], data['pw']))
        rows = cursor.fetchall()
        for row in rows:
            phone = row[0]
            pw = row[1]
            seat_time = row[2]
            result = {"phone" : phone,"pw" : pw,"seat_time" : seat_time, "check" : "true"}
                 
        conn.commit()
        conn.close()
        
        if result['check'] == 'true':
            return result
        else:
            result1 = {"check" : "false"}
            return result1

    except Exception as e:
          return jsonify({'check': 'false'})


@app.route('/Findpw', methods=['POST']) #비밀번호 찾기 요청
def Findpw():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
                return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
        
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "select pw from Members where phone = %s and email = %s"
        cursor.execute(sql,(data['phone'], data['email']))
        rows = cursor.fetchall()
        for row in rows:
            pw = row[0]
            result = {"pw" : pw, "check" : "true"}
        conn.commit()
        conn.close()
        
        if result['check'] == 'true':
            return result
        else:
            result1 = {"check" : "false"}
            return result1
        
    except Exception as e:
          return jsonify({'check': 'false'})


@app.route('/FindTicket', methods=['POST']) #이용권 이름 출력해주는 요청
def FindTicket():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': 'No data provided'}), 400 # data가 없을 시 웹페이지에 400 오류

        id = data.get('id')  # JSON 데이터에서 t_name 값을 가져옴
        conn = app.db_connection
        cursor = conn.cursor()


        sql = "SELECT t_name, t_money, origin_id FROM Ticket WHERE id =  %s"  # t_name 조건 추가
        cursor.execute(sql, (id))  # t_name 값을 튜플로 전달하여 바인딩

        rows = cursor.fetchall()
        data = []
        for row in rows:
            entry = {
                't_name': row[0],
                't_money': row[1],
                'origin_id' : row[2]
            }
            data.append(entry)
        conn.close()
        return jsonify({'tickets': data, 'check': 'true'}) # check 키를 true로 설정하여 전달

    except Exception as e:
        return jsonify({'error': str(e), 'check': 'false'})


@app.route('/FindTicketTime', methods=['POST']) #선택한 이용권에 시간을 가져오는 요청
def FindTicketTime():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': 'No data provided'}), 400 # data가 없을 시 웹페이지에 400 오류

        t_money = data.get('t_money')  # JSON 데이터에서 t_name 값을 가져옴
        conn = app.db_connection
        cursor = conn.cursor()

        sql = "SELECT t_time, t_name, origin_id FROM Ticket WHERE t_money =  %s"  # t_name 조건 추가
        cursor.execute(sql, (t_money))  # t_name 값을 튜플로 전달하여 바인딩

        rows = cursor.fetchall()
        for row in rows:
            t_time = row[0]
            t_name = row[1]
            id = row[2]
            result = {"t_time" : t_time,"t_name" : t_name,"id" : id, "check" : "true"}
        conn.commit()
        conn.close()
        
        if result['check'] == 'true':
            return result
        else:
            result1 = {"check" : "false"}
            return result1
        
    except Exception as e:
          return jsonify({'check': 'false'})


@app.route('/FindSeatTime', methods=['POST']) #회원의 좌석 시간을 가져오는 함수
def FindSeatTime():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': 'No data provided'}), 400 # data가 없을 시 웹페이지에 400 오류

        phone = data.get('phone')  
        conn = app.db_connection
        cursor = conn.cursor()

        sql = "SELECT seat_time FROM Members WHERE phone =  %s" 
        cursor.execute(sql, (phone))  

        rows = cursor.fetchall()
        for row in rows:
            seat_time = row[0]
            result = {"seat_time" : seat_time,"check" : "true"}
        conn.commit()
        conn.close()
        
        if result['check'] == 'true':
            return result
        else:
            result1 = {"check" : "false"}
            return result1
        
    except Exception as e:
          return jsonify({'check': 'false'})

@app.route('/AddSeatTime', methods=['POST']) #좌석을 구매했을때 디비에 시간을 추가해주는 요청
def AddSeatTime():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()
        phone = data.get('phone')  
        add_time = data.get('add_time')  
        if not data:
               return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
       
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "UPDATE Members SET seat_time = %s WHERE phone = %s"
        params = (add_time,phone)
        a = cursor.execute(sql,params)
        conn.commit()
        conn.close()
        if cursor.rowcount == 1: 
            data = {"check" : "true"}
            return data
        else :
            data = {"check" : "false"}
            return data
    except Exception as e:
          return jsonify({'message': 'Error occurred', 'error':str(e)}), 500

@app.route('/FindSeatNumber', methods=['POST']) # 현재 사용중인 좌석 정보를 가져오는 함수
def FindSeatNumber():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': 'No data provided'}), 400 # data가 없을 시 웹페이지에 400 오류
        conn = app.db_connection
        cursor = conn.cursor()

        sql = "SELECT seat_number FROM Seat WHERE activations =  %s" 
        cursor.execute(sql, (data['activations']))
        rows = cursor.fetchall()

        seat_numbers = []
        count = 0
        for row in rows:
            seat_number = row[0]
            seat_numbers.append(seat_number)
            count += 1
        conn.commit()
        conn.close()
        
        if seat_numbers: #리스트에 seat_number가 존재하면
            return  jsonify ({"seat_numbers" : seat_numbers,"count" : count, "check" : "true"})
        else:
            return jsonify({"count":count, 'check':'false'})
        
    except Exception as e:
          return jsonify({'check': 'false'})

@app.route('/UpdateSeat', methods=['POST']) #좌석을 선택하는 함수
def UpdateSeat():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()
        phone = data.get('phone') 
        seatnumber = data.get('seatnumber')
        activations = data.get('activations')

        if not data:
               return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
       
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "UPDATE Seat SET phone = %s, activations = %s WHERE seat_number = %s"
        params = (phone,activations,seatnumber)
        a = cursor.execute(sql,params)
        conn.commit()
        conn.close()
        if cursor.rowcount == 1: 
            data = {"check" : "true"}
            return data
        else :
            data = {"check" : "false"}
            return data
    except Exception as e:
          return jsonify({'message': 'Error occurred', 'error':str(e)}), 500

@app.route('/FindSeatPhone', methods=['POST']) # 로그인한 사람에 좌석번호를 가져오는 함수
def FindSeatPhone():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': '전달된 데이터가 없습니다.'}), 400 # 데이터가 없을 시 웹페이지에 400 오류 반환
        conn = app.db_connection
        cursor = conn.cursor()

        sql = "SELECT seat_number FROM Seat WHERE phone = %s"
        cursor.execute(sql, (data['phone']))
        rows = cursor.fetchall()

        conn.commit()
        conn.close()
        if rows:  # 조회된 결과가 있으면
            seat_number = rows[0][0]  # 조회된 결과 중 첫 번째 좌석번호를 가져옴
            return jsonify({"seat_number": seat_number, "check": "true"})
        else:
            return jsonify({"seat_number": 'NULL'}) # 조회된 결과가 없으면 'NULL' 값을 반환

    except Exception as e:
        return jsonify({'check': 'false'}) # 예외가 발생한 경우 'check' 값을 'false'로 설정하여 응답


@app.route('/InsertQrNumber', methods=['POST']) #좌석 선택 후 나오는 qr값 저장
def InsertQrNumber():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()
        phone = data.get('phone')  # JSON 데이터에서 t_name 값을 가져옴
        Number = data.get('Number')  # JSON 데이터에서 t_name 값을 가져옴

        if not data:
               return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
       
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "UPDATE Members SET qr_number = %s WHERE phone = %s"
        params = (Number,phone)
        a = cursor.execute(sql,params)

        conn.commit()
        conn.close()
        if cursor.rowcount == 1: 
            data = {"check" : "true"}
            return data
        else :
            data = {"check" : "false"}
            return data
    except Exception as e:
          return jsonify({'message': 'Error occurred', 'error':str(e)}), 500

@app.route('/FindSeatId', methods=['POST']) #좌석 id찾는 함수
def FindSeatId():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
                return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
        
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "select id from Seat where seat_number = %s"
        cursor.execute(sql,(data['seat_number']))
        rows = cursor.fetchall()
        for row in rows:
            id = row[0]
            result = {"id" : id, "check" : "true"}
        conn.commit()
        conn.close()
        
        if result['check'] == 'true':
            return result
        else:
            result1 = {"check" : "false"}
            return result1
        
    except Exception as e:
          return jsonify({'check': 'false'})

@app.route('/FindLockTime', methods=['POST']) #회원의 사물함 사용시간을 가져오는 함수
def FindLockTime():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': 'No data provided'}), 400 # data가 없을 시 웹페이지에 400 오류

        phone = data.get('phone')
        conn = app.db_connection
        cursor = conn.cursor()

        sql = "SELECT lock_time FROM Members WHERE phone =  %s"
        cursor.execute(sql, (phone)) 

        rows = cursor.fetchall()
        for row in rows:
            lock_time = row[0]
            result = {"lock_time" : lock_time,"check" : "true"}
        conn.commit()
        conn.close()
        
        if result['check'] == 'true':
            return result
        else:
            result1 = {"check" : "false"}
            return result1
        
    except Exception as e:
          return jsonify({'check': 'false'})          

@app.route('/UpdateLockTime', methods=['POST']) #사물함 구매했을때 디비에 시간을 추가해주는 요청
def UpdateLockTime():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()
        phone = data.get('phone')  
        add_time = data.get('add_time')  
        if not data:
               return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
       
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "UPDATE Members SET lock_time = %s WHERE phone = %s"
        params = (add_time,phone)
        a = cursor.execute(sql,params)
        conn.commit()
        conn.close()
        if cursor.rowcount == 1: 
            data = {"check" : "true"}
            return data
        else :
            data = {"check" : "false"}
            return data
    except Exception as e:
          return jsonify({'message': 'Error occurred', 'error':str(e)}), 500
    
@app.route('/FindLockPhone', methods=['POST']) # 로그인한 사람에 사물함 번호를 가져오는 함수
def FindLockPhone():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': '전달된 데이터가 없습니다.'}), 400 # 데이터가 없을 시 웹페이지에 400 오류 반환
        conn = app.db_connection
        cursor = conn.cursor()

        sql = "SELECT lock_number FROM Lock WHERE phone = %s"
        cursor.execute(sql, (data['phone']))
        rows = cursor.fetchall()

        conn.commit()
        conn.close()
        if rows:  # 조회된 결과가 있으면
            lock_number = rows[0][0]  # 조회된 결과 중 첫 번째 좌석번호를 가져옴
            return jsonify({"lock_number": lock_number, "check": "true"})
        else:
            return jsonify({"lock_number": 'NULL'}) # 조회된 결과가 없으면 'NULL' 값을 반환

    except Exception as e:
        return jsonify({'check': 'false'}) # 예외가 발생한 경우 'check' 값을 'false'로 설정하여 응답    
    
@app.route('/UpdateLock', methods=['POST']) #사물함을 선택하는 함수
def UpdateLock():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()
        phone = data.get('phone')  # JSON 데이터에서 t_name 값을 가져옴
        locknumber = data.get('lock_number')
        activations = data.get('activations')
        if not data:
               return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
       
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "UPDATE Lock SET phone = %s, activations = %s WHERE lock_number = %s"
        params = (phone,activations,locknumber)
        a = cursor.execute(sql,params)
        conn.commit()
        conn.close()
        if cursor.rowcount == 1: 
            data = {"check" : "true"}
            return data
        else :
            data = {"check" : "false"}
            return data
    except Exception as e:
          return jsonify({'message': 'Error occurred', 'error':str(e)}), 500
    
@app.route('/FindLockNumber', methods=['POST']) #사용중인 사물함 번호를 가져오는 함수
def FindLockNumber():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': 'No data provided'}), 400 # data가 없을 시 웹페이지에 400 오류
        conn = app.db_connection
        cursor = conn.cursor()

        sql = "SELECT lock_number FROM Lock WHERE activations =  %s"    
        cursor.execute(sql, (data['activations']))
        rows = cursor.fetchall()

        lock_numbers = []

        for row in rows:
            lock_number = row[0]
            lock_numbers.append(lock_number)

        conn.commit()
        conn.close()
        
        if lock_numbers: #리스트에 seat_number가 존재하면
            return  jsonify ({"lock_numbers" : lock_numbers, "check" : "true"})
        else:
            return jsonify({'check':'false'})
        
    except Exception as e:
          return jsonify({'check': 'false'})    
    


    ###########################관리자 기능 함수##################################
    
@app.route('/ManagerLogin', methods=['POST']) #로그인 요청
def ManagerLogin():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()
        if not data:
               return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
       
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "select phone, card_number from Manager where phone = %s and card_number = %s"
        cursor.execute(sql,(data['phone'], data['card_number']))
        rows = cursor.fetchall()
        for row in rows:
            phone = row[0]
            card_number = row[1]
            result = {"phone" : phone,"card_number" : card_number,"check" : "true"}
                 
        conn.commit()
        conn.close()
        
        if result['check'] == 'true':
            return result
        else:
            result1 = {"check" : "false"}
            return result1

    except Exception as e:
          return jsonify({'check': 'false'})

@app.route('/FindSeatType', methods=['POST']) # 현재 사용중인 좌석 정보를 가져오는 함수
def FindSeatType():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': 'No data provided'}), 400 # data가 없을 시 웹페이지에 400 오류
        conn = app.db_connection
        cursor = conn.cursor()

        sql = "SELECT COUNT(*) FROM Seat WHERE activations = %s and id = %s" 
        cursor.execute(sql, (data['activations'], data['id']))
        row = cursor.fetchone()

        conn.commit()
        conn.close()
            
        if row[0] > 0:
             return jsonify({"count": row[0], "check": "true"})
    
        else:
            return jsonify({"count": row[0], 'check': 'false'})
        
    except Exception as e:
          return jsonify({'check': 'false'})

@app.route('/FindSeat', methods=['POST'])
def FindSeat():
    app.db_connection = Connection()
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': '전달된 데이터가 없습니다.'}), 400
        conn = app.db_connection
        cursor = conn.cursor()

        sql = "SELECT phone FROM Seat WHERE seat_number = %s"
        cursor.execute(sql, (data['seatnumber'],))
        rows = cursor.fetchall()

        conn.commit()
        conn.close()

        if rows:
            phone = rows[0][0]  # 첫 번째 행의 첫 번째 열 값
            return jsonify({"phone": phone, "check": "true"})
        else:
            return jsonify({"phone": "NULL", 'check' : "false"})

    except Exception as e:
        return jsonify({'check': 'false'})

@app.route('/Count', methods=['POST']) # 현재 사용중인 좌석 정보를 가져오는 함수
def Count():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': 'No data provided'}), 400 # data가 없을 시 웹페이지에 400 오류
        conn = app.db_connection
        cursor = conn.cursor()
        sql = "SELECT COUNT(*) FROM Members" 
        cursor.execute(sql)
        row = cursor.fetchone()

        sql1 = "SELECT COUNT(*) FROM Seat WHERE activations = %s"
        cursor.execute(sql1, (data['activations']))
        row1 = cursor.fetchone()

        sql2 = "SELECT COUNT(*) FROM Lock WHERE activations = %s"
        cursor.execute(sql2, (data['activations']))
        row2 = cursor.fetchone()

        conn.commit()
        conn.close()
            
        result = {
            "count_Member": row[0],
            "count_Seat": row1[0],
            "count_Lock": row2[0],
        }

        if row[0] > 0 or row1[0] > 0 or row2[0] > 0:
            result["check"] = "true"
        else:
            result["check"] = "false"

        return jsonify(result)
        
    except Exception as e:
        return jsonify({'check': 'false'})

@app.route('/FindLock', methods=['POST'])
def FindLock():
    app.db_connection = Connection()
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': '전달된 데이터가 없습니다.'}), 400
        conn = app.db_connection
        cursor = conn.cursor()

        sql = "SELECT phone FROM Lock WHERE lock_number = %s"
        cursor.execute(sql, (data['locknumber'],))
        rows = cursor.fetchall()

        conn.commit()
        conn.close()

        if rows:
            phone = rows[0][0]  # 첫 번째 행의 첫 번째 열 값
            return jsonify({"phone": phone, "check": "true"})
        else:
            return jsonify({"phone": "NULL", 'check' : "false"})

    except Exception as e:
        return jsonify({'check': 'false'})

@app.route('/UpdateTicket', methods=['POST']) #좌석을 선택하는 함수
def UpdateTicket():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()
        t_name = data.get('t_name') 
        t_money = data.get('t_money')
        t_time = data.get('t_time')
        t_money1 = data.get('t_money1')

        if not data:
               return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
       
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "UPDATE Ticket SET t_name = %s, t_money = %s, t_time = %s WHERE t_money = %s"
        params = (t_name,t_money,t_time,t_money1)
        a = cursor.execute(sql,params)
        conn.commit()
        conn.close()
        if cursor.rowcount == 1: 
            data = {"check" : "true"}
            return data
        else :
            data = {"check" : "false"}
            return data
    except Exception as e:
          return jsonify({'message': 'Error occurred', 'error':str(e)}), 500
    
@app.route('/CountGender', methods=['POST'])
def CountGender():
    app.db_connection = Connection()
    data = request.get_json()
    try:
        if not data or 'gender' not in data:
            return jsonify({'message': 'No data provided or missing gender field'}), 400
        
        conn = app.db_connection
        cursor = conn.cursor()
        sql = "SELECT COUNT(*) FROM Members WHERE gender = %s" 
        cursor.execute(sql, (data['gender'],))
        row = cursor.fetchone()

        conn.commit()
        conn.close()

        result = {}

        if row and row[0] > 0:
            result["count_Member"] = row[0]
            result["check"] = "true"
        else:
            result["count_Member"] = 0
            result["check"] = "false"

        return jsonify(result)
        
    except Exception as e:
        return jsonify({'check': 'false'})

@app.route('/FindManager', methods=['POST'])
def Find_manager():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': '데이터가 제공되지 않았습니다'}), 400 # 데이터가 없을 시 웹페이지에 400 오류 반환
        conn = app.db_connection
        cursor = conn.cursor()

        sql = "SELECT phone, pw, email, gender, birth FROM Members" 
        cursor.execute(sql)
        rows = cursor.fetchall()

        manager_info = []
        for row in rows:
            phone, pw, email, gender, birth = row
            manager_info.append({
                'phone': phone,
                'pw': pw,
                'email': email,
                'gender': gender,
                'birth': birth
            })

        conn.commit()
        conn.close()
        
        if manager_info: # 리스트에 정보가 존재하면
            return jsonify({"manager_info": manager_info, "check": "true"})
        else:
            return jsonify({'check': 'false'})
        
    except Exception as e:
        return jsonify({'check': 'false'})
        
@app.route('/FindMember', methods=['POST']) #비밀번호 찾기 요청
def FindMember():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
                return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
        
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "select phone,pw,email,gender,birth from Members where phone = %s"
        cursor.execute(sql,(data['phone']))
        rows = cursor.fetchall()
        for row in rows:
            phone = row[0]
            pw = row[1]
            email = row[2]
            gender = row[3]
            birth = row[4]

            result = {"phone" : phone,"pw" : pw,"email" : email,"gender" : gender,"birth" : birth, "check" : "true"}
        conn.commit()
        conn.close()
        
        if result['check'] == 'true':
            return result
        else:
            result1 = {"check" : "false"}
            return result1
        
    except Exception as e:
          return jsonify({'check': 'false'})

@app.route('/UpdateMember', methods=['POST'])
def UpdateMember():
    app.db_connection = Connection()  # 데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()

        if not data:
            return jsonify({'message': 'No data provided'}), 400

        conn = app.db_connection
        cursor = conn.cursor()

        sql = "UPDATE Members SET phone = %s, pw = %s, email = %s, gender = %s, birth = %s WHERE phone = %s"
        cursor.execute(sql, (data['phone'], data['pw'], data['email'], data['gender'], data['birth'], data['phone1']))

        conn.commit()
        conn.close()

        if cursor.rowcount == 1:
            response_data = {"check": "true"}
        else:
            response_data = {"check": "false"}

        return jsonify(response_data)
    except Exception as e:
        return jsonify({'message': 'Error occurred', 'error': str(e)}), 500

@app.route('/DeleteMember', methods=['POST'])
def DeleteMember():
    app.db_connection = Connection()  # 데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()

        if not data:
            return jsonify({'message': 'No data provided'}), 400

        conn = app.db_connection
        cursor = conn.cursor()

        sql = "delete from Members where  phone = %s"
        cursor.execute(sql,data['phone1'])

        conn.commit()
        conn.close()

        if cursor.rowcount == 1:
            response_data = {"check": "true"}
        else:
            response_data = {"check": "false"}

        return jsonify(response_data)
    except Exception as e:
        return jsonify({'message': 'Error occurred', 'error': str(e)}), 500
    
from datetime import datetime  # datetime 모듈 임포트 추가

@app.route('/AddPayment', methods=['POST'])
def AddPayment():
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': 'No data provided'}), 400

        t_money = data.get('t_money')
        phone = data.get('phone')
        
        with Connection() as conn:
            cursor = conn.cursor()

            sql = "SELECT id, t_name FROM Ticket WHERE t_money = %s"
            cursor.execute(sql, (t_money,))
            rows = cursor.fetchall()
            for row in rows:
                id = row[0]
                t_name = row[1]
                
                # 주문 번호 생성 (대문자 영어 4개 + 숫자 4개)
                order_number = ''.join(random.choice('ABCDEFGHIJKLMNOPQRSTUVWXYZ') for _ in range(4))
                order_number += ''.join(random.choice('0123456789') for _ in range(4))

                # 현재 날짜 및 시간 생성 (형식: 'YYYY-MM-DD HH:mm')
                current_datetime = datetime.now().strftime('%Y-%m-%d %H:%M')

                # Payment 테이블에 데이터 삽입
                if id == 'a':
                    t_name_payment = f"좌석(시간권) 이용권 + {t_name}"
                elif id == 'b':
                    t_name_payment = f"좌석(기간권) 이용권 + {t_name}"
                elif id == 'c':
                    t_name_payment = f"사물함 이용권 + {t_name}"

                sql_insert = "INSERT INTO Payment (order_number, phone, t_name, t_money, dates) VALUES (%s, %s, %s, %s, %s)"
                cursor.execute(sql_insert, (order_number, phone, t_name_payment, t_money, current_datetime))

            conn.commit()

        result = {"check": "true"}
        return result

    except Exception as e:
        print(str(e))
        return jsonify({'check': 'false'})
    
@app.route('/CountTicket', methods=['POST'])
def CountTicket():
    app.db_connection = Connection()
    data = request.get_json()
    try:
        if not data or 't_money' not in data:
            return jsonify({'message': 'No data provided or missing gender field'}), 400
        
        conn = app.db_connection
        cursor = conn.cursor()
        sql = "SELECT COUNT(*) FROM Payment WHERE t_money = %s" 
        cursor.execute(sql, (data['t_money'],))
        row = cursor.fetchone()

        conn.commit()
        conn.close()

        result = {}

        if row and row[0] > 0:
            result["count_Member"] = row[0]
            result["check"] = "true"
        else:
            result["count_Member"] = 0
            result["check"] = "false"

        return jsonify(result)
        
    except Exception as e:
        return jsonify({'check': 'false'})
    
from datetime import date
import calendar  # calendar 모듈을 import 합니다.
@app.route('/SelectPayment', methods=['POST'])
def SelectPayment():
    conn = Connection()
    cursor = conn.cursor()

    try:
        data = request.get_json()
        if not data:
            return jsonify({'message': 'No data provided'}), 400

        year_month = data.get('year_month')
        if not year_month:
            return jsonify({'message': 'Year and month are required'}), 400

        sql = """
            SELECT CONVERT(DATE, dates) AS date, SUM(CONVERT(NUMERIC, t_money)) AS total_money
            FROM Payment
            WHERE CONVERT(VARCHAR(7), dates, 120) = %s
            GROUP BY CONVERT(DATE, dates)
        """
        cursor.execute(sql, (year_month,))
        rows = cursor.fetchall()

        result_dict = {row[0].strftime("%Y-%m-%d"): int(row[1]) if row[1] is not None else 0 for row in rows}

        # 날짜 범위 내의 모든 날짜를 가져와서 결과에 추가합니다.
        result = []
        year, month = map(int, year_month.split('-'))
        last_day = calendar.monthrange(year, month)[1]

        for day in range(1, last_day + 1):
            date_str = f'{year_month}-{day:02d}'
            total_money = result_dict.get(date_str, 0)
            result.append({'date': date_str, 'total_money': total_money})
        return jsonify({'result': result})
        
    except Exception as e:
        print(e)
        return jsonify({'message': str(e)}), 500

@app.route('/SelectMonthPayment', methods=['POST'])
def SelectMonthPayment():
    conn = Connection()
    cursor = conn.cursor()
    try:
        data = request.get_json()
        if not data:
            return jsonify({'message': 'No data provided'}), 400

        year = data.get('year')
        if not year:
            return jsonify({'message': 'Year is required'}), 400

        # 각 월별 매출을 계산하기 위해 반복합니다.
        result = []
        for month in range(1, 13):
            year_month = f'{year}-{month:02d}'  # 연도와 월을 조합하여 yyyy-MM 형식의 문자열 생성

            # 해당 연도와 월에 대한 매출 데이터를 데이터베이스에서 쿼리합니다.
            sql = """
                SELECT SUM(CONVERT(NUMERIC, t_money)) AS total_money
                FROM Payment
                WHERE CONVERT(VARCHAR(7), dates, 120) = %s
            """
            cursor.execute(sql, (year_month,))
            row = cursor.fetchone()
            total_money = row[0] if row and row[0] is not None else 0

            result.append({'year_month': year_month, 'total_money': total_money})

        return jsonify({'result': result})

    except Exception as e:
        print(e)
        return jsonify({'message': str(e)}), 500

@app.route('/SelectYearlyPayment', methods=['POST'])
def SelectYearlyPayment():
    conn = Connection()
    cursor = conn.cursor()
    try:
        data = request.get_json()
        if not data:
            return jsonify({'message': 'No data provided'}), 400

        startYear = data.get('startYear')
        endYear = data.get('endYear')
        if not startYear or not endYear:
            return jsonify({'message': 'startYear and endYear are required'}), 400

        # 시작 연도부터 종료 연도까지의 각 연도별 총 매출을 계산하기 위해 반복합니다.
        result = []
        for year in range(startYear, endYear + 1):
            # 해당 연도에 대한 매출 데이터를 데이터베이스에서 쿼리합니다.
            sql = """
                SELECT SUM(CONVERT(NUMERIC, t_money)) AS total_money
                FROM Payment
                WHERE YEAR(dates) = %s
            """
            cursor.execute(sql, (year,))
            row = cursor.fetchone()
            total_money = row[0] if row and row[0] is not None else 0

            result.append({'year': year, 'total_money': total_money})
        return jsonify({'result': result})

    except Exception as e:
        print(e)
        return jsonify({'message': str(e)}), 500

@app.route('/FindPaymentDetails', methods=['POST'])
def FindPaymentDetails():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': '데이터가 제공되지 않았습니다'}), 400 # 데이터가 없을 시 웹페이지에 400 오류 반환
        conn = app.db_connection
        cursor = conn.cursor()
        phone = data.get('phone')
        sql = "SELECT order_number, t_name, t_money, dates FROM Payment where phone = %s" 
        cursor.execute(sql,phone)
        rows = cursor.fetchall()

        payment_info = []
        for row in rows:
            order_number, t_name, t_money, dates = row
            payment_info.append({
                'order_number': order_number,
                't_name': t_name,
                't_money': t_money,
                'dates': dates
            })
        conn.commit()
        conn.close()
        
        if payment_info: # 리스트에 정보가 존재하면
            return jsonify({"payment_info": payment_info, "check": "true"})
        else:
            return jsonify({"payment_info": payment_info,'check': 'false'})
        
    except Exception as e:
        return jsonify({'check': 'false'})
    
@app.route('/Findkeyword', methods=['POST']) #키워드 가져오기
def Findkeyword():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
        
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "SELECT DISTINCT keyword FROM FAQ"
        cursor.execute(sql)
        rows = cursor.fetchall()
        result = []  # 결과를 저장할 빈 리스트 생성

        for row in rows:
            keyword = row[0]
            result.append({"keyword": keyword})

        # 키워드가 5개 미만인 경우 나머지를 NULL로 채움
        while len(result) < 6:
            result.append({"keyword": "NULL"})

        conn.commit()
        conn.close()

        if result:  # 결과가 비어 있지 않으면
            return jsonify({"check": "true", "keyword": result})  # JSON 형식으로 반환
        else:
            return jsonify({"check": "false"})
    except Exception as e:
        return jsonify({'check': 'false'})

@app.route('/InsertKeyword', methods=['POST']) #회원가입 요청
def InsertKeyword():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()

        if not data:
            return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
       
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "INSERT INTO FAQ(keyword, question, answer) VALUES (%s, %s, %s)"
        cursor.execute(sql, (data['keyword'], data['question'], data['answer']))
        conn.commit()
        conn.close()

        if cursor.rowcount == 1: 
            response = {"check": "true"}
            return jsonify(response)
        else:
            response = {"check": "false"}
            return jsonify(response), 500
    except Exception as e:
        return jsonify({'message': 'Error occurred', 'error': str(e)}), 500

@app.route('/FindFaq', methods=['POST'])
def FindFaq():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': '데이터가 제공되지 않았습니다'}), 400 # 데이터가 없을 시 웹페이지에 400 오류 반환
        conn = app.db_connection
        cursor = conn.cursor()
        keyword = data.get('keyword')
        sql = "SELECT keyword, question, answer FROM FAQ where keyword = %s" 
        cursor.execute(sql,keyword)
        rows = cursor.fetchall()

        Faq_Info = []
        for row in rows:
            keyword, question, answer = row
            Faq_Info.append({
                'keyword': keyword,
                'question': question,
                'answer': answer
            })
        conn.commit()
        conn.close()
        
        if Faq_Info: # 리스트에 정보가 존재하면
            return jsonify({"Faq_Info": Faq_Info, "check": "true"})
        else:
            return jsonify({"Faq_Info": Faq_Info,'check': 'false'})
        
    except Exception as e:
        return jsonify({'check': 'false'})
    
@app.route('/UpdateKeyword', methods=['POST']) #좌석을 구매했을때 디비에 시간을 추가해주는 요청
def UpdateKeyword():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()
        updatekeyword = data.get('updatekeyword')
        keyword = data.get('keyword')
        if not data:
               return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
       
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "update FAQ set keyword = %s where keyword = %s"
        params = (updatekeyword,keyword)
        cursor.execute(sql,params)
        conn.commit()
        conn.close()
        if cursor.rowcount == 1: 
            data = {"check" : "true"}
            return data
        else :
            data = {"check" : "false"}
            return data
    except Exception as e:
          return jsonify({'message': 'Error occurred', 'error':str(e)}), 500
    
@app.route('/DeleteKeyword', methods=['POST']) #좌석을 구매했을때 디비에 시간을 추가해주는 요청
def DeleteKeyword():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()
        keyword = data.get('keyword')
        if not data:
               return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
       
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "delete from FAQ where keyword = %s"
        params = (keyword)
        cursor.execute(sql,params)
        conn.commit()
        conn.close()
        if cursor.rowcount == 1: 
            data = {"check" : "true"}
            return data
        else :
            data = {"check" : "false"}
            return data
    except Exception as e:
          return jsonify({'message': 'Error occurred', 'error':str(e)}), 500

@app.route('/FindQuestion', methods=['POST']) #비밀번호 찾기 요청
def FindQuestion():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
                return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
        
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "select keyword,question,answer from FAQ where question = %s"
        cursor.execute(sql,(data['question']))
        rows = cursor.fetchall()
        for row in rows:
            keyword = row[0]
            question = row[1]
            answer = row[2]

            result = {"keyword" : keyword,"question" : question,"answer" : answer, "check" : "true"}
        conn.commit()
        conn.close()
        
        if result['check'] == 'true':
            return result
        else:
            result1 = {"check" : "false"}
            return result1
        
    except Exception as e:
          return jsonify({'check': 'false'})

@app.route('/UpdateFaq', methods=['POST'])
def UpdateFaq():
    app.db_connection = Connection()  # 데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()

        if not data:
            return jsonify({'message': 'No data provided'}), 400

        conn = app.db_connection
        cursor = conn.cursor()

        sql = "UPDATE FAQ SET question = %s, answer = %s WHERE question = %s"
        cursor.execute(sql, (data['question'], data['answer'], data['originquestion']))

        conn.commit()
        conn.close()

        if cursor.rowcount == 1:
            response_data = {"check": "true"}
        else:
            response_data = {"check": "false"}

        return jsonify(response_data)
    except Exception as e:
        return jsonify({'message': 'Error occurred', 'error': str(e)}), 500

@app.route('/DeleteFaq', methods=['POST'])
def DeleteFaq():
    app.db_connection = Connection()  # 데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()

        if not data:
            return jsonify({'message': 'No data provided'}), 400

        conn = app.db_connection
        cursor = conn.cursor()

        sql = "delete from FAQ where  question = %s"
        cursor.execute(sql,data['question'])

        conn.commit()
        conn.close()

        if cursor.rowcount == 1:
            response_data = {"check": "true"}
        else:
            response_data = {"check": "false"}

        return jsonify(response_data)
    except Exception as e:
        return jsonify({'message': 'Error occurred', 'error': str(e)}), 500
    
@app.route('/InsertFaq', methods=['POST']) #회원가입 요청
def InsertFaq():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()

        if not data:
               return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류
       
        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "insert into FAQ(keyword, question, answer) values (%s, %s, %s)"
        a = cursor.execute(sql, (data['keyword'], data['question'], data['answer']))
        conn.commit()
        conn.close()
        if cursor.rowcount == 1: 
            data = {"check" : "true"}
            return data
        else :
            data = {"check" : "false"}
            return data
    except Exception as e:
          return jsonify({'message': 'Error occurred', 'error':str(e)}), 500
@app.route('/Findquestion', methods=['POST']) #질문 가져오기
def Findquestion():
    app.db_connection = Connection() #데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            app.logger.error('No data provided') # 에러 로그 출력
            return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류

        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "SELECT DISTINCT keyword FROM FAQ"
        cursor.execute(sql)
        rows = cursor.fetchall()
        result = []  # 결과를 저장할 빈 리스트 생성

        for row in rows:
            keyword = row[0]

            # 각 키워드에 대한 질문을 가져옴
            if keyword == "공지사항":
                continue  # 공지사항에서는 질문을 가져오지 않음

            if keyword == "회원정보":
                sql_question = "SELECT TOP 3 question FROM FAQ WHERE keyword = %s"
            elif keyword == "기타":
                sql_question = "SELECT TOP 1 question FROM FAQ WHERE keyword = %s"
            else:
                sql_question = "SELECT TOP 2 question FROM FAQ WHERE keyword = %s"

            cursor.execute(sql_question, (keyword,))
            questions = cursor.fetchall()

            for question in questions:
                result.append({"keyword": keyword, "question": question[0]})

        # 키워드가 5개 미만인 경우 나머지를 NULL로 채움
        while len(result) < 10:  # 키워드당 두 개의 질문이므로 5개의 키워드는 총 10개의 결과가 됨
            result.append({"keyword": "NULL", "question": "NULL"})

        conn.commit()
        conn.close()

        if result:  # 결과가 비어 있지 않으면
            return jsonify({"check": "true", "result": result})  # JSON 형식으로 반환
        else:
            return jsonify({"check": "false"})
    except Exception as e:
        app.logger.error('An error occurred: {}'.format(e))  # 예외가 발생한 경우 에러 로그 출력
        return jsonify({'check': 'false'})

@app.route('/InsertQNA', methods=['POST']) # Q&A 등록 요청
def InsertQNA():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()

        if not data:
            app.logger.error('No data provided') # 로그 출력
            return jsonify({'message': 'No data provided'}), 400 #data가 없을 시 웹페이지에 400오류

        conn = app.db_connection 
        cursor = conn.cursor()

        sql = "INSERT INTO QNA(phone, q_type, q_record, answer, q_time, checks) VALUES (%s, %s, %s, %s, %s, %s)"
        cursor.execute(sql, (data['phone'], data['q_type'], data['q_record'],data['answer'],data['q_time'],data['checks']))
        conn.commit()
        conn.close()

        if cursor.rowcount == 1: 
            response = {"check": "true"}
            return jsonify(response)
        else:
            response = {"check": "false"}
    except Exception as e:
        return jsonify({'message': 'Error occurred', 'error': str(e)}), 500
    
from datetime import datetime

@app.route('/UpdateAnswer', methods=['POST'])
def UpdateAnswer():
    try:
        data = request.get_json()
        if not data:
            return jsonify({'message': '데이터가 제공되지 않았습니다.'}), 400
        
        phone = data.get('phone')  
        q_record = data.get('q_record')
        answer = data.get('answer')  
        checks = data.get('checks')

        conn = Connection()  # Connection 객체를 만들어주세요. 여기서 Connection은 데이터베이스 연결을 담당하는 클래스입니다.
        cursor = conn.cursor()

        sql = "UPDATE QNA SET answer = %s, checks = %s WHERE phone = %s AND q_record = %s"
        params = (answer, checks, phone, q_record)
        cursor.execute(sql, params)
        conn.commit()
        conn.close()
        
        if cursor.rowcount == 1: 
            return jsonify({'check': 'true'})
        else:
            return jsonify({'check': 'false'})
    except Exception as e:
        return jsonify({'message': '오류가 발생했습니다.', 'error': str(e)}), 500

@app.route('/DeleteQNA', methods=['POST'])
def DeleteQNA():
    app.db_connection = Connection()  # 데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()

        if not data:
            return jsonify({'message': 'No data provided'}), 400

        conn = app.db_connection
        cursor = conn.cursor()

        sql = "DELETE FROM QNA WHERE phone = %s AND q_record = %s"
        cursor.execute(sql, (data['phone'], data['q_record']))  # 플레이스홀더에 데이터를 삽입합니다.

        conn.commit()
        conn.close()

        if cursor.rowcount == 1:
            response_data = {"check": "true"}
        else:
            response_data = {"check": "false"}

        return jsonify(response_data)
    except Exception as e:
        return jsonify({'message': 'Error occurred', 'error': str(e)}), 500


@app.route('/FindQNA', methods=['POST'])
def FindQNA():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': '데이터가 제공되지 않았습니다'}), 400 # 데이터가 없을 시 웹페이지에 400 오류 반환
        conn = app.db_connection
        cursor = conn.cursor()

        sql = "SELECT phone, q_type, q_record, answer, q_time, checks FROM QNA WHERE phone = %s"
        cursor.execute(sql, (data['phone'],)) # 'phone' 키에 해당하는 값 사용

        rows = cursor.fetchall()

        manager_info = []
        for row in rows:
            phone, q_type, q_record, answer, q_time, checks = row
            manager_info.append({
                'phone': phone,
                'q_type': q_type,
                'q_record': q_record,
                'answer': answer,
                'q_time': q_time,
                'checks': checks
            })
        conn.commit()
        conn.close()

        if manager_info: # 리스트에 정보가 존재하면
            return jsonify({"manager_info": manager_info, "check": "true"})
        else:
            return jsonify({"manager_info": [],'check': 'false'})
    except Exception as e:
        return jsonify({'check': 'false', 'error': str(e)}) # 에러 메시지 반환

@app.route('/Findqna', methods=['POST'])
def Findqna():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': '데이터가 제공되지 않았습니다'}), 400 # 데이터가 없을 시 웹페이지에 400 오류 반환
        conn = app.db_connection
        cursor = conn.cursor()
        
        if data['checks'] == "NULL":
            sql = "SELECT phone, q_type, q_record, answer, q_time, checks FROM QNA WHERE q_type = %s and checks = 'NULL'"
            cursor.execute(sql,(data['q_type'],))
        elif data['checks'] != "NULL":
            sql = "SELECT phone, q_type, q_record, answer, q_time, checks FROM QNA WHERE q_type = %s and checks != 'NULL'"
            cursor.execute(sql,(data['q_type'],))
        rows = cursor.fetchall()

        manager_info = []
        for row in rows:
            phone, q_type, q_record, answer, q_time, checks = row
            manager_info.append({
                'phone': phone,
                'q_type': q_type,
                'q_record': q_record,
                'answer': answer,
                'q_time': q_time,
                'checks': checks
            })
        conn.commit()
        conn.close()

        if manager_info:
            return jsonify({"manager_info": manager_info, "check": "true"})
        else:
            return jsonify({"manager_info": [], "check": "false"})
    except Exception as e:
        return jsonify({'check': 'false', 'error': str(e)})


@app.route('/FindQNA2', methods=['POST'])
def FindQNA2():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': '데이터가 제공되지 않았습니다'}), 400 # 데이터가 없을 시 웹페이지에 400 오류 반환
        conn = app.db_connection
        cursor = conn.cursor()

        sql = "SELECT phone, q_type, q_record, answer, q_time, checks FROM QNA WHERE phone = %s and q_record = %s"
        cursor.execute(sql, (data['phone'], data['q_record'])) # 'phone' 키에 해당하는 값 사용


        rows = cursor.fetchall()

        manager_info = []
        for row in rows:
            phone, q_type, q_record, answer, q_time, checks = row
            manager_info.append({
                'phone': phone,
                'q_type': q_type,
                'q_record': q_record,
                'answer': answer,
                'q_time': q_time,
                'checks': checks
            })
        conn.commit()
        conn.close()

        if manager_info: # 리스트에 정보가 존재하면
            return jsonify({"manager_info": manager_info, "check": "true"})
        else:
            return jsonify({"manager_info": [],'check': 'false'})
    except Exception as e:
        return jsonify({'check': 'false', 'error': str(e)}) # 에러 메시지 반환

@app.route('/FindAllQna', methods=['POST'])
def FindAllQna():
    app.db_connection = Connection() # 데이터베이스 연결을 Flask 앱 객체에 저장
    data = request.get_json()
    try:
        if not data:
            return jsonify({'message': '데이터가 제공되지 않았습니다'}), 400 # 데이터가 없을 시 웹페이지에 400 오류 반환
        conn = app.db_connection
        cursor = conn.cursor()
        
        if data['checks'] == "NULL":
            sql = "SELECT phone, q_type, q_record, answer, q_time, checks FROM QNA WHERE checks = 'NULL'"
            cursor.execute(sql)
        elif data['checks'] != "NULL":
            sql = "SELECT phone, q_type, q_record, answer, q_time, checks FROM QNA WHERE checks != 'NULL'"
            cursor.execute(sql)
        rows = cursor.fetchall()

        manager_info = []
        for row in rows:
            phone, q_type, q_record, answer, q_time, checks = row
            manager_info.append({
                'phone': phone,
                'q_type': q_type,
                'q_record': q_record,
                'answer': answer,
                'q_time': q_time,
                'checks': checks
            })
        conn.commit()
        conn.close()

        if manager_info:
            return jsonify({"manager_info": manager_info, "check": "true"})
        else:
            return jsonify({"manager_info": [], "check": "false"})
    except Exception as e:
        return jsonify({'check': 'false', 'error': str(e)})
@app.route('/UpdateQuestion', methods=['POST'])
def UpdateQuestion():
    try:
        data = request.get_json()
        if not data:
            return jsonify({'message': '데이터가 제공되지 않았습니다.'}), 400
        
        phone = data.get('phone')  
        q_record = data.get('q_record')
        q_record1 = data.get('q_record1')

        conn = Connection()  # Connection 객체를 만들어주세요. 여기서 Connection은 데이터베이스 연결을 담당하는 클래스입니다.
        cursor = conn.cursor()

        sql = "UPDATE QNA SET q_record = %s WHERE phone = %s AND q_record = %s"
        params = (q_record, phone, q_record1)
        cursor.execute(sql, params)
        conn.commit()
        conn.close()
        
        if cursor.rowcount == 1: 
            return jsonify({'check': 'true'})
        else:
            return jsonify({'check': 'false'})
    except Exception as e:
        return jsonify({'message': '오류가 발생했습니다.', 'error': str(e)}), 500

@app.route('/InsertEvent', methods=['POST'])
def InsertEvent():
    app.db_connection = Connection()  # 데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        conn = app.db_connection
        cursor = conn.cursor()

        data = request.get_json()
        if not data:
            app.logger.error('No data provided')
            return jsonify({'message': 'No data provided'}), 400

        t_name = data.get('name')
        t_money = data.get('money')

        # sale의 백분율에 따라 할인 적용
        sale = data.get('sale', 0)  # sale이 없는 경우 0으로 설정
        discounted_money = int(float(t_money) - (float(t_money) * float(sale) / 100))

        # 첫 번째 쿼리 실행하여 t_time 및 id 가져오기
        sql1 = "SELECT t_time, id FROM Ticket WHERE t_name = %s AND t_money = %s"
        cursor.execute(sql1, (t_name, t_money))
        row = cursor.fetchone()
        if row is None:
            app.logger.error('No data found for the given parameters')
            return jsonify({'message': 'No data found for the given parameters'}), 404

        t_time = row[0]
        origin_id = row[1]

        sql_count = "SELECT COUNT(*) FROM Ticket WHERE id = %s"
        cursor.execute(sql_count, ('d',))
        count = cursor.fetchone()[0]

        if count >= 6:
            data = {"check": "false1"}
            return jsonify(data)

        # 두 번째 쿼리 실행
        sql2 = "INSERT INTO Ticket(id, t_name, t_time, t_money,origin_id) VALUES (%s, %s, %s, %s, %s)"
        try:
            cursor.execute(sql2, ('d', t_name, t_time, discounted_money, origin_id))
            conn.commit()
        except:
            data = {"check": "false"}
            return jsonify(data)

        if cursor.rowcount == 1:
            data = {"check": "true"}
            return jsonify(data)
        else:
            data = {"check": "false"}
            return jsonify(data)

    except Exception as e:
        data = {"check": "false"}
        return jsonify(data), 500
    
@app.route('/DeleteTicket', methods=['POST'])
def DeleteTicket():
    app.db_connection = Connection()  # 데이터베이스 연결을 Flask 앱 객체에 저장
    try:
        data = request.get_json()

        if not data:
            return jsonify({'message': 'No data provided'}), 400
        id = data.get('id')
        t_money = data.get('money')
        t_name = data.get('name')

        print(id)
        print(t_money)
        print(t_name)

        conn = app.db_connection
        cursor = conn.cursor()

        sql = "DELETE FROM Ticket WHERE id = %s and t_money = %s AND t_name = %s"
        cursor.execute(sql, (id,t_money, t_name))  # 플레이스홀더에 데이터를 삽입합니다.

        conn.commit()
        conn.close()

        if cursor.rowcount == 1:
            response_data = {"check": "true"}
        else:
            response_data = {"check": "false"}

        return jsonify(response_data)
    except Exception as e:
        return jsonify({'message': 'Error occurred', 'error': str(e)}), 500




    # 회원 사물함 시간  확인 및 업데이트하는 함수
def update_member_lock():
    app.db_connection = Connection()
    conn = app.db_connection
    cursor = conn.cursor()

    # 모든 회원 정보 가져오기
    cursor.execute("SELECT phone, lock_time FROM Members")
    rows = cursor.fetchall()

    current_time = datetime.now()

    for row in rows:
        phone = row[0]
        lock_time_str = row[1]
        
        if lock_time_str == '0 0 0 0 0':  # 초기화값 처리
            lock_time = None  # 초기화되지 않은 상태를 나타내는 값으로 None 사용
        else:
            lock_time = datetime.strptime(lock_time_str, "%Y %m %d %H %M")

        if lock_time is None or current_time > lock_time:
            # 시간이 경과한 경우 사물함 정보 업데이트
            sql_update = "UPDATE Lock SET phone = NULL, activations = 1 WHERE phone = %s"
            cursor.execute(sql_update, (phone,))
            
            # lock_time 초기화
            sql_reset_time = "UPDATE Members SET lock_time = '0 0 0 0 0' WHERE phone = %s"
            cursor.execute(sql_reset_time, (phone,))
            
            conn.commit()

    conn.close()
# 회원 좌석 시간 확인 및 업데이트하는 함수
def update_member_seat():
    app.db_connection = Connection()
    conn = app.db_connection
    cursor = conn.cursor()

    # 모든 회원 정보 가져오기
    cursor.execute("SELECT phone, seat_time FROM Members")
    rows = cursor.fetchall()

    current_time = datetime.now()

    for row in rows:
        phone = row[0]
        seat_time_str = row[1]
        
        if seat_time_str == '0 0 0 0 0':  # 초기화값 처리
            seat_time = None  # 초기화되지 않은 상태를 나타내는 값으로 None 사용
        else:
            seat_time = datetime.strptime(seat_time_str, "%Y %m %d %H %M")

        if seat_time is None or current_time > seat_time:
            # 시간이 경과한 경우 좌석 정보 업데이트
            sql_update = "UPDATE Seat SET phone = NULL, activations = 1 WHERE phone = %s"
            cursor.execute(sql_update, (phone,))
            
            # seat_time 초기화
            sql_reset_time = "UPDATE Members SET seat_time = '0 0 0 0 0', qr_number = '0 0 0 0 0' WHERE phone = %s"
            cursor.execute(sql_reset_time, (phone,))
            
            conn.commit()
    conn.close()

# 주기적으로 회원 정보 업데이트 함수 호출
def periodic_update():
    while True:
        update_member_seat()
        update_member_lock()
        # 1분에 한 번씩 업데이트
        time.sleep(60)  # time 모듈을 import하여 사용

# 멀티스레딩 시작
update_thread = threading.Thread(target=periodic_update)
update_thread.start()

    
if __name__=='__main__':
    app.run()

