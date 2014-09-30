cd k5c/
for file in *;
do
	crf_test -v1 -m ../model3 $file > ../k5d/$file

done

java DevelopTaggedOutputVariant k5d k5e ../k4 201 100
