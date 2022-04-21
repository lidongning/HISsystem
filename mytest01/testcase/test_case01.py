#写测试流程：调用pages的函数/接口
import unittest
from testfile.test_readExcel import readExcel


class Testinterfaces(unittest.TestCase):
    @classmethod
    def setUpClass(self) -> None:
        print('清理数据！')

    def test_case01(self):
        cell = readExcel().get_xls('../testfile/test_data.xls', 'Sheet1')
        # 函数function1
        # function1(cell[0],cell[1])
        self.assertEqual(1, cell[0])  # 加断言
        return

    @classmethod
    def tearDownClass(self) -> None:
        print('清理数据！')
if __name__ == '__main__':
        unittest.main()  #收集本模块所有的用例