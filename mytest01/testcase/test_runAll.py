# 用例执行的管理
import unittest
import result
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
    test_suite = load_by_class()

    test_report_path = r'../result/report.txt'           #生成测试报告
    file = open('../result/report.txt', 'w').close()     #测试报告清理干净
with open(test_report_path, 'a') as report_file:
    runner = unittest.TextTestRunner(stream=report_file, verbosity=2)
    runner.run(test_suite)
