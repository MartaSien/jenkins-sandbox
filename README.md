# Jenkins playground

### Quick setup

From Jenkins [documentation](https://github.com/jenkinsci/docker/blob/master/README.md)

```
docker pull jenkins/jenkins:latest
docker run -p 8080:8080 -p 50000:50000 --restart=on-failure -v jenkins_home:/var/jenkins_home jenkins/jenkins:latest
```

or with `docker compose up -d`

#### Check if it's running

```
docker compose ps
```

#### View logs

````
docker compose logs -f jenkins
````

#### Stop it

````
docker compose down
````

#### Get initial admin password

```
docker compose exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```

### Cloud agent

#### Required plugins

- Docker Pipeline
- Docker

#### Set up the agent

1. Manage Jenkins → Configure System → Cloud → Add a new cloud → Docker
1. Docker Host URI: `unix:///var/run/docker.sock`
1. Add template with `jenkins/inbound-agent:alpine-jdk21` image, label `docker-agent`

### Verify

In Jenkins console (Manage Jenkins → Script Console): `println "docker --version".execute().text`
- Should output something like: `Docker version 24.x.x, build ...`

### Jenkins Project: Building CI/CD Pipeline for Scalable Web Applications

Final project of KodeKloud course on building CI/CD pipeline in Jenkins.

- source: [course-jenkins-project](https://notes.kodekloud.com/docs/Jenkins-Project-Building-CICD-Pipeline-for-Scalable-Web-Applications/Advanced-Pipelines/Section-Introduction/page)

#### Semantic versioning

- commit starting with fix: bumps the patch version.
- commit starting with feat: bumps the minor version.
- commit starting with feat!: signals a breaking change and bumps the major version.