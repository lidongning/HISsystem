# 读取Excel的方法
import xlrd
import testfile
class readExcel():  # xls_name填写用例的Excel名称 sheet_name该Excel的sheet名称
    def get_xls(self, xls_name, sheet_name):
        cls = []  #list列表

        # 获取用例文件路径
        file =xlrd.open_workbook(xls_name)   # 打开用例Excel
        sheet = file.sheet_by_name(sheet_name) #获得打开Excel的sheet
        # 获取这个sheet内容行数
        rows = sheet.nrows
        cols = sheet.ncols
        for i in range(1,rows):             #根据行-列数做循环
            for j in range(cols):
                cls.append(sheet.cell_value(i,j))
        return cls
if __name__ == '__main__':
      print('读取excel文件！')


