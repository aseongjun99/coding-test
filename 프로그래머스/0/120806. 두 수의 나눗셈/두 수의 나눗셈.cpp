#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int num1, int num2) {
    double num = (double) num1/ (double) num2;

    int answer = num*1000;
    return answer;
}