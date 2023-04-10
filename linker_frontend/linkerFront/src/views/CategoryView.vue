<template>
  <div>
      <el-row style="margin-top: 2vh;">
          <el-col :span="2">
          </el-col>
          <el-col :span="16">
              <el-button type="primary" plain @click="goBack">Back</el-button>
          </el-col>
          <el-col :span="6">
          </el-col>
      </el-row>
      <el-row>
          <el-col :span="4">
          </el-col>
          <el-col :span="16">
              <h2>All groups of &lt {{ categoryInfo }} ></h2>
          </el-col>
          <el-col :span="4">
          </el-col>
      </el-row>
      <el-row style="margin-bottom: 5vh;">
          <el-col :span="18">
          </el-col>
          <el-col :span="6">
              <el-button type="primary" plain @click="createGroup">Create Group</el-button>
          </el-col>
      </el-row>
      <el-row >
          <el-col :span="4">
          </el-col>
          <el-col :span="16">
              <div>
                  <el-card v-for="group in groups" :key="group.id_group">
                  <div slot="header" class="clearfix">
                  <span style="line-height: 36px" class="clickable" @click="goGroup(group.id_group)">>{{ group.name_g }}</span>
                  </div>
                      <div class="text item">{{ group.description }}</div>
                      <div class="text item" style="float: right;">created on {{ group.date }} by {{ group.username }}</div>
                  </el-card>
              </div>
          </el-col>
          <el-col :span="4">
          </el-col>            
      </el-row>
  </div>
</template>
<script lang="ts">
import { ref,reactive,watch,defineComponent } from 'vue';
import axios from 'axios';
import { useRouter,useRoute } from "vue-router";

interface Post {
  id_post:number;
  title: string;
  content: string;
  date: string;
  username: string;
  id_owner:number;
}

interface Group {
  id_group:number;
  name_g: string;
  description: string;
  id_owner:number;
  username:string;
  date: string;
}

export default defineComponent({
  setup() {
    const groups = ref<Group[]>([]);    
    const route = useRoute();
    const router = useRouter();
    const routeQuery = reactive(route.query);
    const idCategory = ref(routeQuery.category);
    const categoryInfo = ref('')
    
    axios.get(`http://localhost:8080/groups/category/${idCategory.value}`)
      .then(response => {
        groups.value = response.data;
        groups.value.forEach((group) => {
          axios.get(`http://localhost:8080/users/${group.id_owner}`)
            .then(userResponse => {
              group.username = userResponse.data.username;
            })
            .catch(error => {
              console.log(error);
            });
        });
        console.log("response:"+groups.value[0].id_group);
      })
      .catch(error => {
        console.log(error);
      });

    watch(groups, (newValue, oldValue) => {
      console.log('groups changed', newValue, oldValue);
    }, {
      deep: true,
    });

    axios.get(`http://localhost:8080/categories/${idCategory.value}`)
      .then(response => {
        categoryInfo.value = response.data.name_category;
      })
      .catch(error => {
        console.log(error);
      });

    watch(groups, (newValue, oldValue) => {
      console.log('groups changed', newValue, oldValue);
    }, {
      deep: true,
    });

    watch(() => route.query, (newVal) => {
            console.log('route.query changed:', newVal);
            Object.assign(routeQuery, newVal);
            idCategory.value = routeQuery.category;
            window.location.reload();
        }, { deep: true });

    
    const createGroup = () =>{
        router.push({
        name: 'creategroup',
        query: {
          idCategory: idCategory.value
        },
      });
    }

    const goGroup = (idGroup) => {
      router.push({
        name: 'group',
        query: {
          idGroup: idGroup
        },
      });
    };

    function goBack() {
      router.back();
    }

    return {
      groups,
      goBack,
      goGroup,
      categoryInfo,
      createGroup
    };
  }
});
</script>
<style scoped>
.clickable{
font-size: larger;
font-weight: bold;
cursor: pointer;
color: #00A8E0;
text-decoration: underline;
}
</style>