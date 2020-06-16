new Vue({
    el:"#app",
    data:{
        user:{
            id:"",
            username:"",
            password:"",
            email:"",
            age:"",
            sex:""
        },
        userList:[]
    },
    methods:{
        findAll:function(){
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/user/findAll')
                .then(function (response) {
                    _this.userList = response.data;//响应数据给userList赋值
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        findByIdforupdate:function (userid) {
            //在当前方法中定义一个变量，表明是vue对象
            $("#myModal #insert").show()
            $("#myModal #update").show()
            var _this = this;
            axios.get('/user/findById',{params:{id:userid}})
                .then(function (response) {
                    _this.user = response.data;//响应数据给user赋值
                    $("#myModal #insert").hide()
                    $("#myModal").modal("show");
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        findByIdforfind:function (userid) {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/user/findById',{params:{id:userid}})
                .then(function (response) {
                    _this.user = response.data;//响应数据给user赋值
                    $("#myModal #insert").hide()
                    $("#myModal #update").hide()
                    $("#myModal").modal("show");
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        update:function (user) {//post请求
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.post('/user/update', _this.user)
                .then(function (response) {
                    _this.findAll();
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        insert:function (user) {//post请求
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.post('/user/insert', _this.user)
                .then(function (response) {
                    _this.findAll();
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        showmymodel:function(){
            var _this = this;
            _this.user = {id:"",
                username:"",
                password:"",
                email:"",
                age:"",
                sex:""};
            $("#myModal #insert").show()
            $("#myModal #update").show()
            $("#myModal #update").hide()
            $("#myModal").modal("show");
        }
    },
    created:function() {//当我们页面加载的时候触发请求，查询所有
        this.findAll();
    }
});