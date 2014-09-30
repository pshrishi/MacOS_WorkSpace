#include <iostream>

using namespace std;

class Person
{
	public:
	virtual void jump() { cout << "Jump" << endl; }
};

class Child : public Person
{
	public:
	void jump() { cout << "Fall" << endl;}
	void nap() { cout << "Nap" << endl; }
};

int main()
{
	void (Person::*fp)() = &Person::jump;
	Person *p = new Child;
	(p->*fp)();

	fp = &Child::nap;
}
