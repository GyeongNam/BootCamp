# for문을 이용하여 hello world1, hello world2 등 100까지 문구가 적힌 파일 생성
    # mydir2 디렉토리 생성
    # 해당 디텍토리 생성
    # 파일안에 helloworld1~helloworld100까지 입력
    # 파일 및 디렉토르 존재 유무 확인시 예외처리까지

echo "start"
dir_name="mydir2"
if  [ -d $dir_name ]; then
    cd mydir2
else
    echo "$dir_name add"
    mkdir mydir2
    cd mydir2
    echo "--> mydir2"
fi


file_name="num.txt"
if  [ -f $file_name ]; then
    echo "$file_name del, add"
    rm -rf num.txt
    touch num.txt
else
    echo "$file_name add"
    touch num.txt
fi

for var in {1..100}
do
echo "hello world $var" >> num.txt
done

cat num.txt

echo "end"