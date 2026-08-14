# Jenkins playground

### Quick setup

From Jenkins [documentation](https://github.com/jenkinsci/docker/blob/master/README.md)

```
docker pull jenkins/jenkins:latest
docker run -p 8080:8080 -p 50000:50000 --restart=on-failure -v jenkins_home:/var/jenkins_home jenkins/jenkins:latest
```

### Jenkins Project: Building CI/CD Pipeline for Scalable Web Applications

Final project of KodeKloud course on building CI/CD pipeline in Jenkins.

- source: [course-jenkins-project](https://notes.kodekloud.com/docs/Jenkins-Project-Building-CICD-Pipeline-for-Scalable-Web-Applications/Advanced-Pipelines/Section-Introduction/page)

#### Semantic versioning

- commit starting with fix: bumps the patch version.
- commit starting with feat: bumps the minor version.
- commit starting with feat!: signals a breaking change and bumps the major version.