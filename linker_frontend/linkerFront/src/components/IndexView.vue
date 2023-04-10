<template>
    <el-container class="layout-container-demo" >
        <el-header style="text-align: right; font-size: 12px;">
          <el-menu
              :default-active="activeIndex"
              class="el-menu-demo"
              mode="horizontal"
              :ellipsis="false"
          >
              <el-menu-item index="0" @click="goHome" style="padding-left: 10vh;"><text class="pageName">Linker</text></el-menu-item>
              <div class="flex-grow" />
              <el-menu-item index="1" @click="goHome">Home</el-menu-item>
              <el-sub-menu index="2">
              <template #title>Category</template>
              <el-menu-item v-for="category in categories" :key="category.id_category" @click="goCategory(category.id_category)" >{{ category.name_category }}</el-menu-item>
              </el-sub-menu>
              <el-menu-item index="4" style="padding-right: 5vh;">Help</el-menu-item>
              <el-button type="primary" style="margin-top: 1.2vh; margin-right: 2vh;" @click="goLogIn">Login</el-button>
            </el-menu>
        </el-header>
        <el-main style="height: 100%;">
            <router-view></router-view>
        </el-main>
    </el-container>
</template>

<script lang="ts">
import { ref,watch } from 'vue'
import { Menu as IconMenu, Message, Setting } from '@element-plus/icons-vue'
import { useRouter,useRoute } from "vue-router";
import axios from 'axios';


interface Category{
  id_category:number;
  name_category:string;
}

export default {
  setup() {
    const categories = ref<Category[]>([]);
    const route = useRoute();
    const router = useRouter()
    const activeIndex = ref('1')
    

    axios.get('http://localhost:8080/categories/all')
      .then(response => {
        categories.value = response.data;
      })
      .catch(error => {
        console.log(error);
      });

    watch(categories, (newValue, oldValue) => {
      console.log('categories changed', newValue, oldValue);
    }, {
      deep: true,
    });

    const goCategory = (key: number) => {
      console.log("goCategory, key="+key);
      router.push({
        name: 'category',
        query: {
          category: key.toString()
        },
      });
    };

    

    
    function goLogIn() {
      router.push('/login')
    }
    function goHome() {
      router.push('/home')
    }

    return {
      activeIndex,
      IconMenu,
      Message,
      Setting,
      goLogIn,
      goHome,
      categories,
      goCategory
    }
  }
}
</script>

<style scoped>
.flex-grow {
  flex-grow: 1;
}
.layout-container-demo .el-header {
  position: relative;
  background-color: var(--el-color-primary-light-7);
  color: var(--el-text-color-primary);
}
.layout-container-demo .el-menu {
    border-right-width: 0;
    padding: 0%;
    font-family: 'popinsregular';
}
.layout-container-demo .el-main {
  padding: 0;
  font-family: 'popinsregular';
}
.pageName{
  font-size: 70px;
  font-weight: 700;
  color: var(--el-color-primary-light-7);
  font-family: 'popinsbold';
}



</style>