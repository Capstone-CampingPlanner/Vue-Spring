import Vue from 'vue'
import Router from 'vue-router'

import HelloWorld from '../components/HelloWorld'
import Board from '../components/Board'
import ContentDetail from '../components/ContentDetail';
import Create from '../components/Create';
import CommentList from '../components/CommentList';
import Signup from '../components/Signup';
import MyProductList from "../components/MyProductList";
import MyProductDetail from "../components/MyProductDetail";
import ProductList from "../components/ProductList";
import Registration from "../components/Registration"
import UserList from "../components/UserList"
import ProductDetail from "../components/ProductDetail";


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/board/free',
      name: 'Board',
      component: Board
    },
    {
      path: '/board/free/detail/:contentId',
      name: 'ContentDetail',
      component: ContentDetail
    },
    {
      path: '/board/free/create/:contentId?', // 필수가 아니라 선택이므로 '?' 추가
      name: 'Create',
      component: Create
    },
    {
      path: '/board/free/create/:contentId?',
      name: 'CommentList',
      component: CommentList
    },
    {
      path: '/signup',
      name: 'Signup',
      component: Signup
    },
    {
      path: '/userList',
      name: 'UserList',
      component: UserList
    },
    {
      path: '/MyProductList',
      name: 'MyProductList',
      component: MyProductList
    },
    {
      path: '/MyProductDetail/:menuid',
      name: 'MyProductDetail',
      component: MyProductDetail,
      props: true
    },
    {
      path: '/ProductList',
      name: 'ProductList',
      component: ProductList
    },
    {
      path: '/registration',
      name: 'Registration',
      component: Registration,
      props: true
    },
    {
      path: '/ProductDetail/:menuid',
      name: 'productDetail',
      component: ProductDetail,
      props: true
    },
  ]
})
