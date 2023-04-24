
describe('我的第一个测试',function(){
    it('百度测试用例1:',function(){
        cy.visit('http://www.baidu.com') //访问url
        cy.title().should('contain','百度一下，你就知道')   //验证页面 title 是否正确
        cy.get('#kw').type('python')       //根据 css 定位搜索输入框
        cy.should('have.value','python')  //验证关键字自动是否展示正确
        cy.get('#su').click()   //根据 css 定位搜索按钮并点击
        cy.title().should('contain','python_百度搜索')  //验证页面 title 是否正确
        cy.screenshot()
    })
        it('百度测试用例2:',function(){
        cy.visit('http://www.baidu.com') //访问url
        cy.get('#kw').type('自动化测试')       //根据 css 定位搜索输入框
        cy.get('#su').click()   //根据 css 定位搜索按钮并点击
        cy.title().should('contain','自动化测试_百度搜索')  //验证页面 title 是否正确
        cy.screenshot()
    })

})
