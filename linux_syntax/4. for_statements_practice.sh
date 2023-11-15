
# for 문을 이용하여 hello world 1, hello world 2 등 1oo까지 echo로 출력

for var in {1..100}
do
    echo "hello world $var" ;
done

# for문을 이용하여 file1.txt, file2.txt 등 100까지의 이름을 가진 파일 생성
for var in {1..100}
do
   touch file$var.txt
done



