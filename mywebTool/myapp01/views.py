from django.http import HttpResponse
from django.shortcuts import render
from django.template import loader
from django.views.decorators.csrf import csrf_exempt
from selenium import webdriver
from selenium.webdriver.chrome.options import Options

from selenium.webdriver.common.by import By


def hello(request):
    t = loader.get_template('index.html')  # 加载模板
    html = t.render({'name': '世界'})  # 渲染模板：content传递字典数据到模板
    return HttpResponse(html)  # 返回响应


# 1.加载模板 2.渲染模板 3.返回响应
@csrf_exempt
def ajax_add(request):
    if request.method == 'POST':  # 判断post请求
        one = request.POST.get('one')  # 拿到ajax发送的数据(如果是列表则需要用到getlist)
        two = request.POST.get('two')
        out = int(one) + int(two)  # 将两个数相加
        return HttpResponse(out)  # 返回给ajax的回调函数
        return render(request, 'index.html')  # 返回到主页面显示


@csrf_exempt
def bai_find(request):
    if request.method == 'POST':  # 判断post请求
        one = request.POST.get('one')
        # option = webdriver.ChromeOptions()
        # option.add_experimental_option("detach", True)  # 浏览器打开3s后，自动关闭：设置浏览器不会自动关闭
        # driver = webdriver.Chrome(chrome_options=option)
        driver_exe = 'chromedriver'
        options = Options()
        options.add_argument("--headless")
        driver = webdriver.Chrome(driver_exe, options=options)  # 隐藏浏览器，后台运行
        driver.get('https://baidu.com')
        driver.implicitly_wait(5)
        driver.find_element(By.ID, 'kw').send_keys(one)
        driver.find_element(By.ID, 'su').click()
        str1 = driver.find_element(By.XPATH, '//*[@id="tsn_inner"]/div[2]/span').text
        return HttpResponse(str1)
        return render(request, 'index.html')  # 返回到主页面显示


@csrf_exempt
def content_find(request):
    if request.method == 'POST':  # 判断post请求
        one = request.POST.get('one')
        driver_exe = 'chromedriver'
        options = Options()
        options.add_argument("--headless")
        driver = webdriver.Chrome(driver_exe, options=options)  # 隐藏浏览器，后台运行
        driver.get('https://baidu.com')
        driver.implicitly_wait(5)
        driver.find_element(By.ID, 'kw').send_keys(one)
        driver.find_element(By.ID, 'su').click()
        str1 = driver.find_element(By.XPATH, '//*[@id="tsn_inner"]/div[2]/span').text
        return HttpResponse(str1)
        return render(request, 'index.html')  # 返回到主页面显示
