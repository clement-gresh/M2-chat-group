<template>
    <div style="margin-top: 10%;">
        <el-row :gutter="20" min-width="100" >
            <el-col :span="8"><div class="grid-content ep-bg-purple" /></el-col>
            <el-col :span="8"><div class="grid-content ep-bg-purple" />
                <div style="width: 400px; text-align: center;">
                <el-form :model="form" label-width="80px">
                    <el-form-item label="Username">
                    <el-input v-model="form.username"></el-input>
                    </el-form-item>
                    <el-form-item label="Password">
                    <el-input v-model="form.password" type="password"></el-input>
                    </el-form-item>
                    <el-form-item prop="email" label="Email" >
                        <el-input v-model="form.email" />
                    </el-form-item>
                    <el-form-item label="Birthdate">
                        <div class="block">
                            <span class="demonstration"></span>
                            <el-date-picker
                              v-model="birthday"
                              type="date"
                              placeholder="Pick a day"
                              :disabled-date="disabledDate"
                              :shortcuts="shortcuts"
                              :size="size"
                            />
                        </div>
                    </el-form-item>
                    <el-form-item label="Firstname">
                    <el-input v-model="form.firstname"></el-input>
                    </el-form-item>
                    <el-form-item label="Lastname">
                    <el-input v-model="form.lastname"></el-input>
                    </el-form-item>
                    <el-form-item label="Telephone">
                    <el-input v-model="form.telephone"></el-input>
                    </el-form-item>
                    <el-form-item class="btm">
                    <el-button type="primary" @click="handleSubmit">Sign Up</el-button>
                    <el-button @click="goLogIn">Already user? </el-button>
                    </el-form-item>
                </el-form>
                    </div>
            </el-col>
            <el-col :span="8"><div class="grid-content ep-bg-purple" /></el-col>
        </el-row>
    </div>
</template>

<script>
import { reactive, ref} from 'vue'
import { useRouter } from "vue-router";
import axios from 'axios'

export default {
  setup() {
    const form = reactive({
      username: '',
      password: '',
      email: '',
      firstname: '',
      lastname: '',
      telephone: 0
    })
    const router = useRouter()
    const birthday = ref('')

    const handleSubmit = () => {
      const formattedDate = new Date(birthday.value).toISOString().split('T')[0];
      const user = {
        username: form.username,
        password: form.password,
        birthday: formattedDate,
        email: form.email,
        firstname: form.firstname,
        lastname: form.lastname,
        telephone: form.telephone
      }
      axios.post('http://localhost:8080/users/', user)
        .then(res => {
          console.log('SignUp success', res)
          router.push('/login')
        })
        .catch(error => {
          console.error('SignUp fail', error)
        })
    }

    return {
      form,
      handleSubmit,
      birthday,
      router
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