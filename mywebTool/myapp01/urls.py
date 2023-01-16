from django.template.defaulttags import url
from django.urls import path, re_path

from . import views
from .views import ajax_add

urlpatterns = [
    path('', views.hello, name='hello'),
]
