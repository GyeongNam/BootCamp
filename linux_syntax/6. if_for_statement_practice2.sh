# practice3 start 라는 문구 출력
# mydir3 폴더 생성
# 폴더로 이동
# 해당 폴더에서 file1~ file 100 까지 100개의 파일을 만들고
# 해당 파일마다 각각 hello world from file1 ,hello world from file2 ... 입력
# -> 각 파일마다 100개씩 똑같은 문구
# practice3 completed 출력
echo "practice3 start"

mkdir mydir3
cd mydir3

for var in {1..100}
do
    touch file_$var.txt
    for var2 in {1..100}
    do
        echo "hello world from file$var">>file_$var.txt
    done
done

echo "practice3 completed"