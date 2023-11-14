
# 사용자가 위치에 있는 폴더 경로 출력
pwd

# 현재위치 파일,폴더 목록
ls 

# + 상세정보
ls -l

# + 숨김파일
ls -al

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

# 편집기 nano myscript.sh 
# mkdir jo_dir
# cd jo_dir
# touch first_file.txt
# cat first_file.txt
# echo "hello world" > first_file.txt
# cat first_file.txt

# 권한 chmod 777(모든 권한)
# 스크립트 실행 방법 ./myscript.sh

# 이전 디렉토리로 돌아가기
cd -