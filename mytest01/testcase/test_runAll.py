# 用例执行的管理
import os.path
import sys
import unittest
file_path=os.path.abspath(__file__)   #为了保证在cmd中可以运行python文件,添加路径
cur_path=os.path.dirname(file_path)
project_path=os.path.dirname(cur_path)
sys.path.append(project_path)
from testcase import test_case01


def load_by_class():    #通过测试类来添加到测试集当中
    suite = unittest.TestSuite()
    loader= unittest.TestLoader()
    load_suite=loader.loadTestsFromTestCase(test_case01.Testinterfaces)
    suite.addTests(load_suite)
    return suite
if __name__ == '__main__':
    print('运行所有用例！')
    runner=unittest.TextTestRunner()
    file = open('C:\\My-Files-Dn\\git-code\\mytest01\\result\\report.txt', 'w').close()#测试报告清理干净
with open(r'C:\\My-Files-Dn\\git-code\\mytest01\\result\\report.txt', 'a') as report_file:
    runner = unittest.TextTestRunner(stream=report_file, verbosity=2)
    runner.run(load_by_class())
