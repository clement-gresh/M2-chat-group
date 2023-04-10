<template>
    <div style="margin-top: 10%;">
        <el-row :gutter="20" min-width="100" >
            <el-col :span="8"><div class="grid-content ep-bg-purple" /></el-col>
            <el-col :span="6"><div class="grid-content ep-bg-purple" />
                <div style="width: 400px; text-align: center;">
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item label="Usernamme">
                    <el-input v-model="form.username"></el-input>
                    </el-form-item>
                    <el-form-item label="Password">
                    <el-input v-model="form.password" type="password"></el-input>
                    </el-form-item>
                    <el-form-item class="btm">
                    <el-button type="primary" @click="submitForm">Log In</el-button>
                    <el-button @click="goSignUp">Sign Up</el-button>
                    </el-form-item>
                </el-form>
                    </div>
            </el-col>
            <el-col :span="10"><div class="grid-content ep-bg-purple" /></el-col>
        </el-row>
    </div>
</template>
<script>
import { ref } from 'vue';
import { useRouter,useRoute } from "vue-router";

export default {
  setup() {
    const route = useRoute();
    const router = useRouter()
    
    const form = ref({
      username: '',
      password: '',
    });

    function submitForm() {
      form.value.$refs.form.validate((valid) => {
        if (valid) {
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    }

    function goSignUp() {
      router.push('/signup')
    }

    return {
      form,
      submitForm,
      goSignUp,
    };
  },
};
</script>

<style>
.btm{
    margin-left: 80px;
}
</style>