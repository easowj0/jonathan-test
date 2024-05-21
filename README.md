# HelloWorld Kubernetes Application

## Deployment Instructions
1. Install RancherDesktop to local machine: https://rancherdesktop.io/ 
2. Using the nerdctl cli that comes packaged with RancherDesktop, run the following command from the project root (demo) to build the Dockerfile for use with Kubernetes
'nerdctl --namespace k8s.io build -t testapp .'
3. Deploy the image into your cluster using the following command inside the deployments folder
'kubectl create -f hello-world-deployment.yaml'
4. Expose deployment to traffic outisde of the cluster using the following command. This tells Kubernetes to expose the application externally via a NodePort. Traffic will get routed from the exposed NodePort to the port (abstracted service port, which is exposed in the cluster) to the targetPort (port container accepts traffic on)
'kubectl expose deploy hello-world-deployment --type=NodePort --port=8080 --target-port=8080'
5. Hit the running application on the exposed endpoint through your browser
'http://localhost:30889/api/hello'
6. Run the following command to setup Role Based Access Control for the fluentd logging agent which will aggregate logs from the running pods
'kubectl create -f rbac.yaml'
7. Run the following command to deploy the fluentd logging agent collecting logs to an elasticsearch instance
'kubectl create -f fluentd-daemonset-elasticsearch.yaml'