# A-tool-for-batch-grammer-detection-of-Cplusplus
## 原理：
gcc命令行"g++ *.cpp -o *.out"，若程序语法正确，则会成功生成.out文件。
通过统计无.out文件的.cpp文件，可筛选出语法错误的C++程序文件，用于进一步核实。功能有限，仅供参考。

## Run
The order of run: 
CopyFile(update "fromPath") ---> CompileCpp---> GetFailFile
