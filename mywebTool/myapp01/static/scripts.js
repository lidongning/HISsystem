function myFunction0()
{
        alert('你好');
        window.open("https://www.baidu.com/","网页",'with=400px,height=500px')
        var str1= document.getElementById("name").value
        var str2= document.getElementById("prd").value
        if(str1=="1"&& str2=="1" )
        {
          document.getElementById("result").value='提交成功'

        }
       else{
          document.getElementById("result").value='提交失败'
       }

}



