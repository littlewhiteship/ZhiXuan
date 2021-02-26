<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">职选后台管理</div>
            <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
                <el-form-item prop="username">
                    <el-input v-model="param.username" placeholder="请输入用户名" suffix-icon="el-icon-edit">
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input
                        type="password"
                        placeholder="请输入密码"
                        v-model="param.password"
                        @keyup.enter.native="submitForm()"
                        suffix-icon="el-icon-edit"
                    >
                    </el-input>
                </el-form-item>
                <div class="login-btn">
                    <el-button type="primary" @click="submitForm()">登录</el-button>
                </div>
                <p class="login-tips">Tips : 请输入用户名和密码。</p>
            </el-form>
        </div>
    </div>
</template>

<script>
export default {
    data: function() {
        return {
            param: {},
            rules: {
                username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
                password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
            },
        };
    },
    methods: {
        submitForm() {
            this.$refs.login.validate(valid => {
                if (valid) {
                    if(this.param.username=='admin'&&this.param.password=='Admin@123')
                    {
                        this.$message.success('登录成功');
                        this.$router.push('/recruit');
                    }
                    else if(this.param.username!='admin')
                    {
                        this.$message.error('管理员账号有误！')
                    }
                    else if(this.param.password!='Admin@123')
                    {
                        this.$message.error('管理员密码有误！')
                    }
                    else
                    {
                        this.$message.error('账号密码有误！')
                    }
                } else {
                    this.$message.error('请输入账号和密码');
                    console.log('error submit!!');
                    return false;
                }
            });
        },
    },
};
</script>

<style scoped>
.login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-image: url(../assets/img/login.jpg);
    background-size: 100%;
}
.ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: -190px 0 0 -175px;
    border-radius: 5px;
    background: rgba(255, 255, 255, 0.3);
    overflow: hidden;
}
.ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: #000;
    border-bottom: 1px solid #ddd;
}
.ms-content {
    padding: 30px 30px;
}
.login-btn {
    text-align: center;
}
.login-btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
}
.login-tips {
    font-size: 12px;
    line-height: 30px;
    color: rgb(248, 8, 8);
}
</style>