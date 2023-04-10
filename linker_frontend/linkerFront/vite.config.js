import { fileURLToPath, URL } from 'node:url'
import { defineConfig } from 'vite'
import requireTransform from 'vite-plugin-require-transform';
import vue from '@vitejs/plugin-vue'
import vueJsx from '@vitejs/plugin-vue-jsx'
const path = require('path');

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue(), vueJsx(),requireTransform({
    fileRegex: /.js$|.vue$/
  })],
  define: {
    'process.env': {},
  },
  resolve: {
    alias: {
      '@': path.resolve(__dirname, 'src'),
      '@assets': path.resolve(__dirname, 'src/assets')
    }
  },
  server: {
    cors: true,
    port: 7777,
    proxy: {
      "/api": {
        target: "http://localhost:8080",
        secure: false,
        changeOrigin: true, //this one is declare for cross
        rewrite: (path) => {console.log(path); return path.replace(/^\/api/, '')}
      }
    }
  },
  build: {
    assetsDir: 'assets',
    rollupOptions: {
      output: {
        assetFileNames: 'images/[name].[ext]',
        chunkFileNames: 'js/[name].js',
        entryFileNames: 'js/[name].js'
      }
    }
  }
})
