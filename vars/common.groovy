def compile(){
if(app_lang == "nodejs") {
    sh 'npm install'
    sh 'env'

     }
    if (app_lang == "maven") {
        sh "mvn package"
    }

}

def unittests() {
    if(app_lang == "nodejs") {
        // developer is missing unit test cases in our project,we need to add them as best practice,we are skipping to proceed further
       sh 'npm test'

    }
    if (app_lang == "maven") {
        sh "mvn test"
    }

    if (app_lang == "python") {
        sh "python3 -m unittest"
    }

}
def email(email_note) {
    sh 'env'
    mail bcc: '', body: 'JOB FAILED - ${JOB_BASE_NAME}\nJenkins URL - ${JOB_URL}', cc: '', from: 'pavanikakarlapudi1990@gmail.com', replyTo: '', subject: 'testing jenkins', to: 'pavanikakarlapudi1990@gmail.com'
}