from xml.etree.ElementTree import ElementTree

from suds import client  #第三方库 suds

import result


def interface_one():
    url='http://ws.webxml.com.cn/webservices/qqOnlineWebService.asmx?wsdl'
    web_s=client.Client(url)
    print(web_s)           #打印服务地址返回的所有接口方法
    s1={'qqCode':'123456'}
    result=web_s.service.qqCheckOnline(s1['qqCode']) #方法内传参
    #data = ElementTree.XML(result.decode('utf-8'))  #如果返回的是xml格式，就解析响应编码
    #print(data.find('Code').text)
    print(result)
    return

if __name__ == '__main__':
    interface_one()
    print('测试接口')
