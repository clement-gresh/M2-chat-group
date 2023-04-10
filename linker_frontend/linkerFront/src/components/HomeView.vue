<template>
  <div>
    <el-row :gutter="20" min-width="100" style="height: 50vh;">
      <el-col :span="6"></el-col>
      <el-col :span="12">
        <div class="block text-center" m="t-4">
          <el-carousel trigger="click" height="42vh" style="width=50vh">
            <p></p>
            <el-carousel-item v-for="item in items" :key="item">
              <img :src="item.imgUrl" class="carImg">
            </el-carousel-item>
          </el-carousel>
        </div>
      </el-col>
      <el-col :span="6"></el-col>
    </el-row>
    <el-row :gutter="20" min-width="100">
      <el-col :span="2"></el-col>
      <el-col :span="13">
        <div class="grid-content ep-bg-purple">
          <p class="discussionHit">Top Post!</p>
          <div>
            <el-card v-for="post in posts" :key="post.id_post">
              <div slot="header" class="clearfix">
                <span style="line-height: 36px" class="clickable" @click="goPost(post.id_post)">>{{ post.title }}</span>
              </div>
              <div class="text item"><p>{{ post.content }}</p></div>
              <div class="text item" style="float: right;">created on {{ post.date }} by {{ post.username }}</div>
            </el-card>
          </div>
        </div>
      </el-col>
      <el-col :span="7">
        <div class="grid-content ep-bg-purple">
          <p class="groupsHit">Groups hit!</p>
          <div>
            <el-card v-for="group in groups" :key="group.id_group">
              <div slot="header" class="clearfix">
                <span style="line-height: 36px" class="clickable" @click="goGroup(group.id_group)">{{ group.name_g }}</span>
              </div>
              <div class="text item">{{ group.description }}</div>
            </el-card>
          </div>
        </div>
      </el-col>
      <el-col :span="2"></el-col>
    </el-row>
  </div>
</template>


<script lang="ts">
import { defineComponent, ref, watch, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router'
import item1 from '@/images/item1.jpg'
import item2 from '@/images/item2.jpg'
import item3 from '@/images/item3.jpg'

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
}


export default defineComponent({
  setup() {
    const posts = ref<Post[]>([]);
    const groups = ref<Group[]>([]);
    const router = useRouter();

    const items = ref([
      { title: 'Item 1', imgUrl: item1 },
      { title: 'Item 2', imgUrl: item2 },
      { title: 'Item 3', imgUrl: item3 },
    ]);


    axios.get('http://localhost:8080/posts/all')
      .then(response => {
        posts.value = response.data;
        posts.value.forEach((post) => {
          axios.get(`http://localhost:8080/users/${post.id_owner}`)
            .then(userResponse => {
              post.username = userResponse.data.username;
            })
            .catch(error => {
              console.log(error);
            });
        });
        console.log("response:"+posts.value[0].id_post);
      })
      .catch(error => {
        console.log(error);
      });

    watch(posts, (newValue, oldValue) => {
      console.log('posts changed', newValue, oldValue);
    }, {
      deep: true,
    });

    axios.get('http://localhost:8080/groups/all')
      .then(response => {
        groups.value = response.data;
        console.log("response:"+groups.value[0].name_g);
      })
      .catch(error => {
        console.log(error);
      });

    watch(groups, (newValue, oldValue) => {
      console.log('groups changed', newValue, oldValue);
    }, {
      deep: true,
    });

    const goPost = (idPost) => {
      router.push({
        name: 'post',
        query: {
          idPost: idPost
        },
      });
    };
    const goGroup = (idGroup) => {
      router.push({
        name: 'group',
        query: {
          idGroup: idGroup
        },
      });
    };

    onMounted(() => {
      console.log('Component mounted');
    });

    return {
      posts,
      groups,
      goGroup,
      goPost,
      items
    };
  }
});
</script>



<style scoped>
.flex-grow {
  flex-grow: 1;
}
.layout-container-demo .el-header {
  position: relative;
  background-color: var(--el-color-primary-light-7);
  color: var(--el-text-color-primary);
  font-size: 50px;
}
.layout-container-demo .el-menu {
    border-right-width: 0;
    padding: 0%;
}
.layout-container-demo .el-main {
  padding: 0;
}
.welcome{
    font-family: 'popinsthinitalic', sans-serif;
    font-style: normal;
    font-weight: 700;
    font-size: 30px;
    line-height: 120px;
    display: flex;
    align-items: center;
    text-align: center;
    color: var(--el-color-primary-light-7);
    padding-left: 20%;
}
.discussionHit{
   font-family:'popinsregular',sans-serif;
    font-style: normal;
    font-weight: 700;
    font-size: 24px;
    line-height: 36px;
    display: flex;
    color: #232020;

}
.groupsHit{
    font-family:'popinsregular',sans-serif;
    font-style: normal;
    font-weight: 700;
    font-size: 24px;
    line-height: 36px;
    display: flex;
    color: #232020;
}
.clickable{
  font-size: larger;
  font-weight: bold;
  cursor: pointer;
  color: #00A8E0;
  text-decoration: underline;
}
.carImg{
  width: 100%;
  height: 100%;
}
</style>
