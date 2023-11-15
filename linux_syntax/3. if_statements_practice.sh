# 2일차

# if 문을 사용하여 만약 현재 폴더에 first.txt 파일이 있으면 exist출력.
# 없다면 does not exit 출력

mkdir mydir
cd mydir
# 변수화
file_name="first.txt" # 띄어쓰기하면 안된다...
if  [ -f $file_name ]; then
    echo "$file_name exist"
    else
    echo "$file_name does not exit"
fi