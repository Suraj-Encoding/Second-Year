// # Assignment-4 -> CRC
// # Write a program for error detection and correction for 7/8 bits ASCII codes using CRC
#include <iostream>
using namespace std;

// # Variables
char msg[20], key[20], temp[20];
int *dataword, *divisor, *quotient;
bool valid;
int i, j, k = 0;

// # Functions #

// # Calculation of CRC
void CRC()
{
    for (i = 0; i < strlen(msg); i++)
    {
        if (dataword[i] == 1)
        {
            quotient[i] = 1;
            for (j = 0; divisor[i] != '\0'; j++)
                dataword[i + j] ^= divisor[j];
        }
        else
            quotient[i] = 0;
    }
}

// # Display Data
void display()
{
    // # Display Codeword
    if (k == 0)
    {
        k = 1;
        cout << "\n Codeword: ";
        for (i = 0; i < strlen(msg); i++)
            if (msg[i] == '1')
                dataword[i] = 1;
            else
                dataword[i] = 0;
        for (i = 0; dataword[i] != '\0'; i++)
            cout << dataword[i];
        cout << endl;
    }

    // # Display Quotient
    cout << " Quotient: ";
    for (i = 0; i < strlen(msg); i++)
        cout << quotient[i];
    cout << endl;

    // # Display CRC
    cout << " CRC: ";
    for (i = strlen(msg); dataword[i] != '\0'; i++)
        cout << dataword[i];
    cout << endl;
}

// # Check validity
void validity()
{
    valid = true;
    for (i = 0; dataword[i] != '\0'; i++)
        if (dataword[i] == 1)
        {
            valid = false;
            break;
        }
    if (valid == true)
    {
        cout << "Data stream is valid." << endl;
        cout << "Final data: " << temp << endl;
    }
    else
        cout << "Data stream is Invalid. CRC error occurred.\n\n";
}

// # Main Function
int main()
{
    // # Sender Side

    // # Input Data Stream
    cout << "\n# CRC - Error Detection # " << endl;
    cout << "# Sender Side: " << endl;
    cout << " Enter data: ";
    cin >> msg;
    cout << " Enter key: ";
    cin >> key;
     
   
    // # Arrays
    dataword = new int[strlen(msg) + strlen(key) - 1];
    divisor = new int[strlen(key)];
    quotient = new int[strlen(msg)];
    // # Converion of char string to integer array
    for (i = 0; i < strlen(msg); i++)
        if (msg[i] == '1')
            dataword[i] = 1;
        else
            dataword[i] = 0;

    for (i = 0; i < strlen(key); i++)
        if (msg[i] == '1')
            divisor[i] = 1;
        else
            divisor[i] = 0;

    // # Functions
    CRC();
    display();

    // # Receiver Side
    cout << "\n# Receiver Side: " << endl;
    cout << " Enter codeword: ";
    cin >> msg;
    dataword = new int[strlen(msg) + strlen(key) - 1];
    quotient = new int[strlen(msg)];
    for (i = 0; i < strlen(msg); i++)
        if (msg[i] == '1')
            dataword[i] = 1;
        else
            dataword[i] = 0;

    // # Functions
    CRC();
    display();
    validity();
    return 0;
}
