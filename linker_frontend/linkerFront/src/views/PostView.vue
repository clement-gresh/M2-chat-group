<template>
    <div v-if="post">
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
          <div>
            <h2>{{ post.title }}</h2>
            <p>{{ post.content }}</p>
            <p>Written by {{ post.username }}  on {{ post.date }}</p>
            <el-button type="primary" plain @click="likePost(post.nblike)">
                  <el-badge :value="post.nblike" class="badge"></el-badge>
                </el-button>
          </div>
        </el-col>
        <el-col :span="4">
        </el-col>
      </el-row>
      <el-row v-for="comment in comments" :key="comment.id_comment">
          <el-col :span="4">
          </el-col>
          <el-col :span="16">
            <el-card >
              <div slot="header" class="clearfix">
                <p style="line-height: 36px" class="clickable">{{ comment.content }}</p>
                <p style="float: right;">Replyed by {{ comment.username }}  on {{ comment.date }}</p>
                <el-button type="primary" plain @click="likeComment(comment.id_comment,comment.content,comment.date,comment.id_owner,comment.nblike)">
                  <el-badge :value="comment.nblike" class="badge"></el-badge>
                </el-button>
              </div>
            </el-card>
          </el-col>
          <el-col :span="4">
          </el-col>
      </el-row>
      <el-row style="margin-top: 10vh ;">
        <el-col :span="4">
        </el-col>
        <el-col :span="16">
          <el-input v-model="inputReply" type="textarea" :rows="4" :placeholder="commentPlaceholder" />
        </el-col>
        <el-col :span="4">
        </el-col>
      </el-row>
      <el-row style="margin-top: 2vh;">
        <el-col :span="4">
        </el-col>
        <el-col :span="16">
          <el-button type="primary" plain @click="handleReply">Reply</el-button>
        </el-col>
        <el-col :span="4">
        </el-col>
      </el-row>
    </div>
</template>


<script lang="ts">
import { ref,reactive,watch } from 'vue';
import axios from 'axios';
import { useRouter,useRoute } from "vue-router";
import { defineComponent } from 'vue';
  
interface Post {
  id_post:number;
  title: string;
  content: string;
  date: string;
  username: string;
  id_owner: number;
  nblike:number;
}

interface Comment {
  id_comment: number;
  content: string;
  date: string;
  id_owner: number;
  id_post: number;
  username: string;
  nblike:number;
}

interface User {
  id_user: number;
  username: string;
}

export default defineComponent({
  setup() {
    const post = ref<Post>({ id_post: 0, title: '', content: '', date: '', username:'',id_owner: 0, nblike:0 });
    const comments = ref<Comment[]>([]); 
    const commentPlaceholder = ref('Share your opinion here!');
    const route = useRoute();
    const router = useRouter();
    const routeQuery = reactive(route.query);
    const id = ref(routeQuery.idPost);

    const inputReply = ref('')
    


    axios.get(`http://localhost:8080/posts/${id.value}`)
      .then(response => {
        post.value = response.data;
        axios.get(`http://localhost:8080/users/${post.value.id_owner}`)
          .then(userResponse => {
            post.value.username = userResponse.data.username;
          })
          .catch(error => {
            console.log(error);
          });
      })
      .catch(error => {
        console.log(error);
      });

    watch(post, (newValue, oldValue) => {
      console.log('post changed', newValue, oldValue);
    }, {
      deep: true,
    });

    axios.get(`http://localhost:8080/comments/post/${id.value}`)
      .then(response => {
        comments.value = response.data;
        comments.value.forEach((comment) => {
          axios.get(`http://localhost:8080/users/${comment.id_owner}`)
            .then(userResponse => {
              comment.username = userResponse.data.username;
            })
            .catch(error => {
              console.log(error);
            });
        });
      })
      .catch(error => {
        console.log(error);
      });

    watch(post, (newValue, oldValue) => {
      console.log('post changed', newValue, oldValue);
    }, {
      deep: true,
    });

    const handleReply = () => {
      const formattedDate = new Date().toISOString().split('T')[0];
      const comment = {
        content: inputReply.value,
        date: formattedDate,
        id_owner: 2,
        id_post: id.value,
        nblike: 0
      }
      axios.post('http://localhost:8080/comments/', comment)
        .then(res => {
          console.log('reply success', res)
          location.reload()
        })
        .catch(error => {
          console.error('reply fail', error)
        })
    }

    const likePost = async(nblikeOld) => {
      nblikeOld = nblikeOld + 1;
      post.value.nblike = nblikeOld;
      try {
        const response = await axios.post(`http://localhost:8080/posts/`, post.value);
        const updatedPost = response.data;
        post.value = updatedPost; 
      } catch (error) {
        console.error(error);
      }
    };

    const likeComment = async(idComment,content,date,id_owner,nblikeOld) => {
      nblikeOld = nblikeOld + 1;
      const comment = {
        id_comment: idComment,
        content: content,
        date: date,
        id_owner: id_owner,
        id_post: id.value,
        nblike: nblikeOld
      }
      try {
        const response = await axios.post(`http://localhost:8080/comments/`, comment);
        const updatedComment = response.data;
        const index = comments.value.findIndex(comment => comment.id_comment === updatedComment.id_comment);
        if (index !== -1) {
          comments.value.splice(index, 1, updatedComment);
        }
      } catch (error) {
        console.error(error);
      }
    };

    function goBack() {
      router.back();
    }

    return {
      post,
      goBack,
      comments,
      inputReply,
      commentPlaceholder,
      handleReply, 
      likePost,
      likeComment
    };
  }
});

</script>
<style>

</style>