cd /e/Users/workspace/eclipse/sanluan_cms
git add -A .
git commit -m "change"
git push
read –n | -p “Press any key to continue...” INP
if [[ $INP != ‘ ’ ]] ;then
    echo –n ‘\b \n’
fi