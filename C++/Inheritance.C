#include <iostream>

class Base
{
/*	private:
	int x;
*/	protected:
	int y;
	public:
	int z;  
};

class Derived : private Base
{
	public:
	void update()
	{
/*		++x;
		std::cout<< "X: " << x;
*/		++y;
		std::cout<< "Y: " << y << std::endl;
		++z;
		std::cout<< "Z: " << z << std::endl;		
	}

};

int main()
{
	Derived *d = new Derived();
	d->update();
}
