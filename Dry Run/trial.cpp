#include <iostream>
using namespace std;
int main()
{
    int h, res;
    h = 0;
    int time;
    cout << "Enter time: ";
    cin >> time;
    if (time < 60)
    {
        cout << "Time is: " << 0 << "hr " << abs(time) << "min " << endl;
    }
    else if(time % 60 ==0){
        cout << "Time is: " << time/60 << "hr " << 0 << "min " << endl;
    }
    else
    {
        while (1)
        {
            res = time - 60;
            time = res;
            if (res > 0)
                h++;
            if(time<60)
                break;
        }
        cout << "Time is: " << h << "hr " << abs(time) << "min " << endl;
    }
    return 0;
}