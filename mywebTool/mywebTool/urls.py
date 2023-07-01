from django.contrib import admin
from django.urls import include, path, re_path
from myapp01.views import ajax_add, bai_find
urlpatterns = [
    path('admin/', admin.site.urls),
    path('myapp01/', include('myapp01.urls')),   #将应用程序的视图链接到项目，匹配地址
    path('ajax_add/', ajax_add),              #地址与视图函数的映射
    path('bai_find/', bai_find),
]
