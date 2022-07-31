# 调用该类的方法，用来打印生成日志
#-------------------数据类型：数字 字符串 List列表 元组 字典--------------
counter = a1 = 100  # 变量counter是没有类型，她仅仅是一个对象的引用
name = "John"
print (counter)
print (a1)
print (name[1:5])
del a1  #删除对象引用
a1=34
print (a1)

list=["111","345","asd"]
print (list[2]*2+"链接")
list=["333333",555]
list.append('caifengli')
list.insert(2,'dong')
list.remove('caifengli')
print (list[0:4])

trop1=("qw",123,"33","ddff") #元组中的元素值是不允许修改
trop2=('2','dd')
newtrop=trop1+trop2
print (newtrop[0:5])

back={"1":"ee",('2'):"uu",'1':'dong'} #字典的key-value重复赋值，只会记住最后一个
print(back["1"])
print(back['2'])
print (back.keys())  #输出所有key
print (back.values()) #输出所有values

print('11',)

#------------------条件语句-----------------------------
flag=False;a=True
print('11',a)       #字符串连接后，打印字符串
if flag:
    print("你好")
elif a:
    print("我好")
else:
    print("大家好")
#----------------------------循环语句--------------------------
count=0
while count<7:
    count +=1
    if count==4:
        continue   #跳出本次循环，不打印4
    if count==6:
        break      #跳出整个循环，剩余的语句不执行了
    print(count)

count1=0
while count1< 7:
    count1 += 1
    print(count1)
else:
    print ("大于等于7")

    fruits=['aa','bb1','cc','dd']
    for index in range(len(fruits)):
        if '1'in fruits[index]:
            print(fruits[index])
        else:
            print("水果已经卖完 ！")
#--------------日期与时间-------------
import time
time1=time.time()
time1=time.asctime(time.localtime(time.time()))
print(time1)
time2=time.strftime("%Y%m%d",time.localtime())  #日期格式化
print(time2)

import calendar
ca=calendar.month(2022,4)
print(ca)

#--------------------自定义函数----------------------------------
#在 python 中，strings, tuples, 和 numbers 是不可更改的对象，而 list,dict 等则是可以修改的对象
def function(a,c=5):
    print(a[1])
    print(c)
    return
a=['22',3,'uu']
function(a)             #少传一个参数，默认取函数的5



sum=lambda a,b:a+b   #lambda函数只有一行代码，没有代码块
print(sum(10,2))

