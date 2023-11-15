
# 사용자가 위치에 있는 폴더 경로 출력
pwd

# 현재경로
.

# 이전경로
..

# 현재위치 파일,폴더 목록
ls 

# + 상세정보
ls -l

# + 숨김파일
ls -al

# +시간순으로 정렬
ls -alrt

# 디렉토리(폴더) 생성
mkdir jo_dir

# 디렉토리 변경
cd jo_dir

# 홈 디렉토리로 이동
cd

# 루트 디렉토리 이동
cd /

# 다시 기존 폴더로 이동 (절대경로 이용)
cd /home/gyeongnam/jo_dir

# 이전 디렉토리로 돌아가기
cd -

# 상위 폴더로 이동
cd ..

# 비어있는 파일 만들기 파일 존재시 수정시간 변경
touch first_file.txt

# 파일 내용 조회
cat first_file.txt

# 문자열 출력
echo "hello world"

# echo를 통해 파일에 덮어 쓰기하는 방법
echo "hello world" > first_file.txt

# echo를 통해 파일에 추가 쓰기하는 방법
echo "hello world16" >> first_file.txt

# 파일 읽기하는 방법 sort 명령어와 함계 많이 사용
sort < first_file.txt

# # 명령어 도중 취소
# [ctrl + c]

# 자동완성 tab
# 도스키 (회살표) 이전 명령어 사용 가능

# 이전 명령어 조회
history

# 입력중인 터미널 화면 정리
clear

# 파일 삭제
rm

# 디렉토리까지 삭제
rm -r

# 디렉토리까지 (경고문)묻지 않고 삭제
rm -rf jo_dir

# 파일 복사 
#cp 복사할 파일 복사된 파일명(경로 포함) 상위폴더 (../)
cp  first_file.txt second_file.txt

# 디렉토리 까지 복사
cp -r test_dir /jo_dir

# 파일이나 디렉토리 이동(잘라내기 효과) 
# mv 이동 대상 이동왼파일명(경로 포함)
# 파일명 변경시에도 사용
mv test_dir/ jo_dir/secomd_dir

# 텍스트를 작성된 파일의 상위 n행 출력 (기본 10행)
head -5 first_file.txt

# 텍스트로 작성된 파일의 하위 n행 출력 (기본 10행)
tail -5 first_file.txt

# 파이프라인 왼쪽 명령어 실행 값을 오른쪽 명령어로 전달
"명령어1" | "명령어2"

# 쉘 제어문

if[조건] ; then
    # 참일때
    elif [다른조건] ; then
    # 첫 조건이 거짓이고 다른 조건이 참일 때
    else
    # 모든 조건이 거짓일 때
fi

# for 반복문

for [변수] in [항목들]; 
do
# 반복할 예정
done

# 파일 내에서 특정 패턴이나 문자열을 검색
# grep [옵션] [패턴] [파일명]
grep -rin "hello" mydir

# 디렉토리내 모든 검색
grep -r

# 대소문자 구분없이 검색
grep -i

# 라인수 출력
grep -n

# 입력받은 파일은 하나씩 읽는다
xargs

# 파일이나 디렉토리를 찾아 위치 출력
# find [경로] [옵션] [행동]
find . -name "*.txt"
# -name 옵션 : 파일명 검색
# -type : 타입으로 검색 (-d -f)
# -exec : 찾은 파일은 실행 
# - \   : exec의 종료지점을 의미
# - {}  : find로 찾은 대상이 담기는 공간을 의미

# 사용예시
# find . -type -f -name "*.txt" : 현재폴더에서 파일타입중 .txt로 끝나는 파일명 검색
# 활용예시
# find . -name "*.txt" | xargs grep -n "hello"
# find . -name "*.txt" -exec cp -r {} ./testfolder \;

find . -name "*.txt" -exec grep -rni "hello" {} \;

# 신규 사용자 생성

#새로운 유저를 만들면서 그룹지정 및 홈 디렉토리 지정
sudo useradd -g gyeongnam -d /home/newuser1 newuser1

# 신규유저 패스워드 지정 : tlseoqkd123
sudo passwd newuser1

mkdir newuser1

# 신규유저로 계정 전환
sudo su newuser1

# 계정전환 종료
exit

# 계정삭제
sudo userdel newuser1

# 소유자 : 소유그룹 : 그외에 대한 권한을 부여
chmod xxx test.txt

# 4(r)2(w)1(x)
# 소유자한테 읽기, 실행 권한, 그룹한테는 실행권한, others에게 권한 x

#실습
# 유저에 write 권한 더하기 , 그룹에서 실행권한 빼기 , 그외 read 권한만 설정
chmod u+w test.txt
chmod g-x test.txt
chmod o+r test.txt

# 폳더 소유자 변경
sudo chown newuser1:gyeongnam test.txt

# NGINX 웹 서버 실습
sudo systemctl start nginx
sudo systemctl stop nginx

# 프로세스 관련 (작업중인)
kill -9 [PID]

# 특정 프로세스 찾기
ps -ef | grep -i "nginx"

# ip 정보등 네트워크 설정정보 출력
ifconfig

#네트워크 원결 상태 확인
ping

# 넷켓 패스체크
nc-zv naver.com 443

# 현재 서버에 연결된 네트워크 정보 출력
netstat

# 원격 호스트와의 터미널 세션을 제공 ex) ssh [username]@[hosrtname/ip] 
ssh 

# 파일 전송 ex) scp [source] [destination]
scp

# vi 에디터
# nano , vim 에디터도 많이 사용
# vi는 명령모드와 입력모드로 구성
vi [파일명]

# 입력모드
# i     : 현재 커서부터 입력
# o     : 다음줄 커서부터 입력
# x     : 현재 커서가 위치한 단어 삭제
# dd    : 현재 커서가 위치한 행 삭제
# yy    : 현재 커서가 위치한 행 복사
# p     : 현재 행 이후에 붙여넣기
# a     : 그다음 커서 입력

# 명령모드
# esc
# 파일 저장
:w!
# 저장없이 vi 종료
:q!
 # 저장후 vi 종료
:wq!
# G         : 파일의 마지막 줄로 이동
# gg        : 파일의 첫 줄로 이동
# Crtl + f  : 한페이지 아래로 이동
# Crtl + b  : 한페이지 위로 이동
# /         : 검색하기