#include <iostream>

class Point
{
	int x, y;
	public:
	Point() { x=0; y=0; std::cout<<"D"; }
	Point(int a, int b) { x=a; y=b; std::cout<<"2"; }
	Point(int a) { x=a; y=0; std::cout<< "1"; }
};

int main()
{
	Point o;
	Point start(4);
	Point mid = 6;
	Point end(start);
	Point p();
	return 1;
}
