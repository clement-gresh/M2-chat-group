<template>
    <div style="margin-top: 10%;">
        <el-row :gutter="20" min-width="100" >
            <el-col :span="8"><div class="grid-content ep-bg-purple" /></el-col>
            <el-col :span="8"><div class="grid-content ep-bg-purple" />
                <div style="width: 400px; text-align: center;">
                <el-form :model="formPost" label-width="80px">
                    <el-form-item label="Title">
                      <el-input v-model="formPost.title"></el-input>
                    </el-form-item>
                    <el-form-item label="Content">
                      <el-input v-model="formPost.content" type="textarea" :rows="4" :placeholder="contentPlaceholder" />
                    </el-form-item>
                    <el-button type="primary" @click="handleCreate">Create</el-button>
                </el-form>
                    </div>
            </el-col>
            <el-col :span="8"><div class="grid-content ep-bg-purple" /></el-col>
        </el-row>
    </div>
</template>

<script>
import { reactive, ref} from 'vue'
import { useRouter,useRoute } from "vue-router";
import axios from 'axios'

export default {
  setup() {
    const formPost = reactive({
      title: '',
      content: '',
      date: '',
    })
    const router = useRouter();
    const route = useRoute();
    const routeQuery = reactive(route.query);
    const idGroup = ref(routeQuery.idGroup);

    const handleCreate = () => {
      const formattedDate = new Date().toISOString().split('T')[0];
      const post = {
        title: formPost.title,
        content: formPost.content,
        date: formattedDate,
        id_owner: 2,
        id_group: idGroup.value,
        nblike: 0,
      }
      axios.post('http://localhost:8080/posts/', post)
        .then(res => {
          console.log('create post success', res)
          router.push({
            name: 'group',
            query: {
              idGroup: idGroup.value
            },
          });
        })
        .catch(error => {
          console.error('create post fail', error)
        })
    }

    return {
      formPost,
      router,
      handleCreate
    }
  }
}
</script>
  
<style>
.btm{
    margin-left: 70px;
}
.demo-date-picker {
  display: flex;
  width: 100%;
  padding: 0;
  flex-wrap: wrap;
}

.demo-date-picker .block {
  padding: 30px 0;
  text-align: center;
  border-right: solid 1px var(--el-border-color);
  flex: 1;
}

.demo-date-picker .block:last-child {
  border-right: none;
}

.demo-date-picker .demonstration {
  display: block;
  color: var(--el-text-color-secondary);
  font-size: 14px;
  margin-bottom: 20px;
}
</style>