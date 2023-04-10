<template>
    <div style="margin-top: 10%;">
        <el-row :gutter="20" min-width="100" >
            <el-col :span="8"><div class="grid-content ep-bg-purple" /></el-col>
            <el-col :span="8"><div class="grid-content ep-bg-purple" />
                <div style="width: 400px; text-align: center;">
                <el-form :model="formGroup" label-width="120px">
                    <el-form-item label="Group Name">
                      <el-input v-model="formGroup.name_g"></el-input>
                    </el-form-item>
                    <el-form-item label="Description">
                      <el-input v-model="formGroup.description" type="textarea" :rows="4" placeholder="Write here" />
                    </el-form-item>
                    <el-button type="primary" @click="handleCreate">Create</el-button>
                </el-form>
                    </div>
            </el-col>
            <el-col :span="8"><div class="grid-content ep-bg-purple" /></el-col>
        </el-row>
    </div>
</template>


<script lang="ts">
import { reactive, ref} from 'vue'
import { useRouter,useRoute } from "vue-router";
import axios from 'axios'

interface Category{
  id_category:number;
  name_category:string;
}

export default {
  setup() {
    const formGroup = reactive({
      name_g: '',
      description: '',
      date: '',
    })
    const router = useRouter();
    const route = useRoute();
    const routeQuery = reactive(route.query);
    const idCategory = ref(routeQuery.idCategory);

    const handleCreate = () => {
      const formattedDate = new Date().toISOString().split('T')[0];
      const group = {
        name_g: formGroup.name_g,
        description: formGroup.description,
        date: formattedDate,
        id_owner: 2,
        id_category: idCategory.value,
      }
      axios.post('http://localhost:8080/groups/', group)
        .then(res => {
          console.log('create group success', res)
          router.push({
            name: 'category',
            query: {
              category: idCategory.value
            },
          });
        })
        .catch(error => {
          console.error('create group fail', error)
        })
    }

    return {
      formGroup,
      router,
      handleCreate,
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