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
                <h2>All posts in the group &lt {{ groupInfo }} ></h2>
            </el-col>
            <el-col :span="4">
            </el-col>
        </el-row>
        <el-row style="margin-bottom: 5vh;">
            <el-col :span="18">
            </el-col>
            <el-col :span="6">
                <el-button type="primary" plain @click="createPost">Create Post</el-button>
            </el-col>
        </el-row>
        <el-row >
            <el-col :span="4">
            </el-col>
            <el-col :span="16">
                <div>
                    <el-card v-for="post in posts" :key="post.id_post">
                    <div slot="header" class="clearfix">
                    <span style="line-height: 36px" class="clickable" @click="goPost(post.id_post)">>{{ post.title }}</span>
                    </div>
                        <div class="text item">{{ post.content }}</div>
                        <div class="text item" style="float: right;">created on {{ post.date }} by {{ post.username }}</div>
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

export default defineComponent({
  setup() {
    const posts = ref<Post[]>([]);    
    const route = useRoute();
    const router = useRouter();
    const routeQuery = reactive(route.query);
    const id = ref(routeQuery.idGroup);
    const groupInfo = ref('')
    
    axios.get(`http://localhost:8080/posts/group/${id.value}`)
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

    axios.get(`http://localhost:8080/groups/${id.value}`)
      .then(response => {
        groupInfo.value = response.data.name_g;
      })
      .catch(error => {
        console.log(error);
      });

    watch(posts, (newValue, oldValue) => {
      console.log('posts changed', newValue, oldValue);
    }, {
      deep: true,
    });

    const createPost = () =>{
        router.push({
        name: 'createpost',
        query: {
          idGroup: id.value
        },
      });
    }

    const goPost = (idPost) => {
      router.push({
        name: 'post',
        query: {
          idPost: idPost
        },
      });
    };

    function goBack() {
      router.back();
    }

    return {
      posts,
      goBack,
      goPost,
      groupInfo,
      createPost
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