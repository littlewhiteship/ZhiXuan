import Vue from "vue"
import Router from "vue-router"
import login from "./components/login.vue"
import layout from "./components/commons/layout.vue"
import recruit from "./components/back_manage/recruit_info.vue"
import delete_recruit from "./components/back_manage/delete_recruit.vue"
import feedback from "./components/back_manage/feedback.vue"
import ad from "./components/back_manage/ad_pic.vue"
import recruit_excel from "./components/back_manage/recruit_excel.vue"


Vue.use(Router);

export default new Router({
    routes:[
        {
            path:"/login",
            component:login,
            meta: { title: '登录' },
        },
        {
            path:"/",
            component:layout,
            children:[
                {
                    path:"/recruit",
                    component:recruit,
                    meta:{title:'招聘信息上传'},
                },
                {
                    path:"/recruit_batch",
                    component:recruit_excel,
                    meta:{title:'招聘信息批量上传'},
                },
                {
                    path:"/delete",
                    component:delete_recruit,
                    meta:{title:'招聘信息删除'},
                },
                {
                    path:"/feedback",
                    component:feedback,
                    meta:{title:'意见反馈'},
                },
                {
                    path:"/ad",
                    component:ad,
                    meta:{title:'广告图片'},
                }
            ],
        }
    ],
});