# 현재위치 파일, 디렉토리 갯수(*은 모든것을 의미)

file_count=0
directory_count=0
else_count=0

for a in *
do
    if [ -f $a ]; then
    ((file_count++))
    elif [ -d $a ]; then
     ((directory_count++))
    else
     ((else_count++))
    fi
done

echo "file's count: $file_count"
echo "directory's count: $directory_count"
echo "else's count: $else_count"