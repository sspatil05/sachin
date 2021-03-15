branch = "master"
git_url = "https://github.com/sspatil05/sachin.git"

freeStyleJob('create-update-ec2-stack-devl') {
    logRotator(numToKeep = 100)
    parameters {

        stringParam("ENVIRONMENT", "devl")

        choiceParam("OPERATIONS", ["dry_run","deploy","delete"])
        choiceParam("RE_CREATE", ["false","true"])
    }
    scm {
	    git {
            remote {
                  url(git_url)
                 
            }
            branch(branch)
        }
    }
    steps {
        shell( '''



if [ "$RE_CREATE" = false ]
then
   FORCE_DELETE=""
else
   FORCE_DELETE=--force_delete
fi

python --version
python -m cloud_common.aws_stack_operation \\
--region us-east-1 \\
--role_name $ROLE_NAME \\
--account_number $ACCOUNT_NUMBER \\
--operation $OPERATIONS \\
--arch $ARCH_FILE \\
--var $VAR_FILE \\
--stack_name $STACK_NAME \\
--config_file $CONFIG_FILE \\
--template_url $TEMPLATE_URL \\
--log DEBUG $FORCE_DELETE $USE_EXISTING
        ''')
    }
}
