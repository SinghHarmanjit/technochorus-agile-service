# technochorus-agile-service
Serverless and Java project providing lambdas as backend to technochorus site

### Map a custom domain to API Gateway
Configure the plugin serverless-domain-manager to create a custom domain and
add Route 53 record to direct calls to that domain instead of AWS URL
<api-id>.execute-api.<region>.amazonaws.com

command> serverless create_domain

### Code and deploy a simple lambda
Check serverless.yml file for lambda configuration

command> serverless deploy
