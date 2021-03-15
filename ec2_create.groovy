import boto3
ec2 = boto3.resource('ec2')

# create a new EC2 instance
instances = ec2.create_instances(
     ImageId='ami-0915bcb5fa77e4892',
     MinCount=1,
     MaxCount=2,
     InstanceType='t2.micro',
	 region='us-west-2',
     KeyName='test-aws-key'
 )
 
