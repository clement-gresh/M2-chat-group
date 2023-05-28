# Linker
### Membre du groupe:

Zimeng ZHANG.  Yajie LIU.  Clement GRESH

### Instructions pour l'exécution du projet:

**Base de donnée:**
Installer MySQL sur votre ordinateur.

Importer le fichier *linker_chatgroup.sql pour créer le BDD.*

Indiquer l'URL, le nom d'utilisateur et le mot de passe pour la BDD dans le fichier linker_backend/Linker/src/main/resources/application.properties.

---

**Backend:**

Il existe plusieurs façons d'exécuter une application Spring Boot sur votre ordinateur local. Une manière consiste à exécuter la méthode main depuis l'IDE. Ouvrir le projet dans un IDE tel que Eclipse ou Intellij IDEA. Exécuter la méthode main dans la classe *‘*````````````````````com.example.linker.LinkerApplication````````````````````*’* depuis l'IDE.

---

**Frontend:**

Une fois que le back-end a démarré, vous pouvez démarrer le front-end. Utilisez cd *frontend* ou n'importe quel IDE (VS Code, WebStorm...) pour ouvrir ce dossier.

Assurez-vous que le back-end est en cours d'exécution, puis vous pouvez utiliser:

```bash
cd linker_frontend/linkerFront
```

```bash
*npm install*
```

```bash
*npm run dev*
```

pour exécuter la partie fronend. Ouvrez [http://127.0.0.1:5173/](http://127.0.0.1:5173/) avec votre navigateur pour voir le résultat.
