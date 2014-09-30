cd k5a/
cat * > ../k5b/trainData.txt
cd ..
crf_learn -f 3 -c 1.5 template k5b/trainData.txt model3
