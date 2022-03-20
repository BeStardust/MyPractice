#include<stdio.h>
#include<string.h>
#include<stdlib.h>

typedef struct Goods
{
	char name[20];
	float price;
	int number;
	char type[20];
	struct Goods *next;
}goods,*pgoods;

pgoods read(void);//读入数据
pgoods add(char strtype[]);//增加货物类型
int judgetype(pgoods head,char strtype[]);//判断类型是否存在
pgoods addgoods(char strname[],float price,int number,char strtype[]);//增加新货物
int judgename(pgoods head,char strname[],char strtype[]);//判断货物是否已经存在
void goodplus(pgoods head,char strname[],int delta);//入库
void goodreduce(pgoods head,char strname[],int delta);//出库
void del(pgoods head,char strtype[]);//删除类型名
void delname(pgoods head,char strname[]);//删除货物名
void outputtype(pgoods head);//向屏幕输出类型列表
int count(char strtype[]);//统计该类型下的货物种数
void stockoutput(pgoods head,char strgoods[]);//货物库存显示
void searchname(pgoods head,char strname[]);//全局搜索货物名
void delempty(pgoods head);//退出程序前删除操作过程中产生的垃圾数据
void write(pgoods head);//数据写入文件
void destroy(pgoods head);//回收内存

int main()
{
	FILE *fp;
	char ch,chname;
	char strtype[20]="empty";
	char strname[20]="EMPTY";
	int temp1;
	int delta=0;
	float price=0;
	int number=0;
	fp=fopen("a.txt","a+");
	if(fp==NULL)
	{
		printf("程序运行失败！请在同级目录下建立a.txt文本文件！\n");
		exit(0);
	}

	printf("Tips:\t1、英文输入请控制在16个字母以内！\n");
    printf("\t   中文输入请控制在 8个汉字以内！\n");
	printf("    \t2、建议您不要强制退出程序！\n\n操作指令如下:\n");
	while(1)
	{
		pgoods head=NULL;
		printf("\t***********************************************\n");
		printf("\t*********************执行菜单******************\n");
		printf("\tA:显示货物类型列表;\t");
		printf("\tB:增加货物类型;    \n");
		printf("\tC:删除货物类型;    \t");
		printf("\tD:货物入库;        \n");
		printf("\tE:货物出库;        \t");
		printf("\tF:库存显示;        \n");
		printf("\tG:删除货物;        \t");
		printf("\tH:货物全局搜索;    \n");
		printf("\tI:清屏             \t");
		printf("\tJ:退出!            \n");    //退出操作可清除无用数据，因此建议您不要强制退出！
		printf("\t***********************************************\n\n");
		
		printf("您想执行:");
		scanf("%c",&ch);
		fflush(stdin);
		if(ch=='A')
		{
			printf("\n");
			head=read();
			outputtype(head);
			destroy(head);
		}
		if(ch=='B')
		{
			printf("\n请输入您想增加的类型名:");
			scanf("%s",strtype);
			fflush(stdin);
			head=read();
			temp1=judgetype(head,strtype);
            if(temp1==1) 
			{
				head=add(strtype);
				write(head);
				destroy(head);
				printf("  添加成功!\n\n");
			}
			else
			{
				printf("  该类型已存在！\n\n");
			}
		}
		if(ch=='C')
		{
			printf("\n请输入您想删除的类型名:");
			gets(strtype);
			head=read();
			del(head,strtype);
			write(head);
			destroy(head);
		}
		if(ch=='D')
		{
			printf("\n");
			head=read();
			outputtype(head);
			printf("请输入您想入库的货物所属类型:");
			scanf("%s",strtype);
			fflush(stdin);
			temp1=judgetype(head,strtype);
			if(temp1==1)
			{
				printf("  您想入库的货物所属类型不存在!\n\n");
			}
			else
			{
			    stockoutput(head,strtype);
				printf("请输入您想入库的货物名:");
				gets(strname);
				temp1=judgename(head,strname,strtype);
				if(temp1 == -1) 
				{
					printf("\n  请输入入库数量(正整数):");
					scanf("%d",&delta);
					fflush(stdin);
					head=read();
					goodplus(head,strname,delta);
					write(head);
					printf("\n  入库成功！\n\n");
				}
				else if(temp1==-2)
				{
					printf("\n  该货物存在但不归属于此类型！请重新操作！\n\n");
				}
				else
				{
					printf("\n  该货物不存在，是否新增？(Y/N):");
					scanf("%c",&chname);
					fflush(stdin);
					
					if(chname=='Y'||chname=='y')
					{
						printf("\n  请输入商品价格:");
						scanf("%f",&price);
						fflush(stdin);
						printf("\n  请输入入库数量:");
						scanf("%d",&number);
						fflush(stdin);
						head=addgoods(strname,price,number,strtype);
						write(head);
					}
					else
					{
						printf("\n  您已退出货物新增！\n\n");
					}
				}
			}
			destroy(head);
		}
		if(ch=='E')
		{
			printf("\n");
			head=read();
			outputtype(head);
			printf("\n请输入您想出库货物的所属类型:");
			scanf("%s",strtype);
			fflush(stdin);
			temp1=judgetype(head,strtype);
			if(temp1==1)
			{
				printf("  您想出库的货物所属类型不存在！\n\n");
			}
			else
			{
				stockoutput(head,strtype);
				printf("请输入您想出库的货物名:");
				gets(strname);
				temp1=judgename(head,strname,strtype);
				if(temp1==-1)
				{
					printf("\n请输入出库数量(正整数):");
					scanf("%d",&delta);
					fflush(stdin);
					goodreduce(head,strname,delta);
					write(head);
					destroy(head);
				}
				else if(temp1==-2)
				{
					printf("\n  该货物存在但不归属于此类型！请重新操作！\n\n");
				}
				else
				{
					printf("\n  该货物不存在，无法执行出库操作！\n  将返回主菜单！\n\n");
				}
			}
		}
		if(ch=='F')
		{
			printf("\n");
			head=read();
			outputtype(head);
			printf("请输入您想查看的货物类型:");
			scanf("%s",strtype);
			fflush(stdin);
			stockoutput(head,strtype);
			destroy(head);
		}
		if(ch=='G')
		{
			printf("\n");
			head=read();
			outputtype(head);
			printf("您想删除的货物所属类型:");
			scanf("%s",strtype);
			fflush(stdin);
			stockoutput(head,strtype);
			printf("\n请输入您想删除的货物名:");
			gets(strname);
			delname(head,strname);
			write(head);
			destroy(head);
		}
		if(ch=='H')
		{
			head=read();
			printf("\n请输入您想搜索的货物名(类型名不可搜索):");
			gets(strname);
			searchname(head,strname);
			destroy(head);
		}
		if(ch=='I')
		{
			system("cls");
		}
		if(ch=='J')
		{
			head=read();
			delempty(head);
			write(head);
 			destroy(head);
			printf("\n\t***************成功退出!***************\n\n");
			exit(0);
		}
		if(ch!='A'&&ch!='B'&&ch!='C'&&ch!='D'&&ch!='E'&&ch!='F'&&ch!='G'&&ch!='H'&&ch!='I'&&ch!='j')
		{
			printf("\n 非法操作！\n\n");
		}
	}
	printf("***************************************\n");	
}
pgoods read(void)
{
	pgoods head,p,s;
	char str[20]="end";
	FILE *fpin;
	head=p=(pgoods)malloc(sizeof(goods)); 
	head->next=NULL;
	fpin=fopen("a.txt","r+");
	
	while(!feof(fpin))
	{
		s=(pgoods)malloc(sizeof(goods));
		strcpy(s->name,str);
		s->price=0;
		s->number=0;
		strcpy(s->type,str);
		fscanf(fpin,"%s%f%d%s",&s->name,&s->price,&s->number,&s->type);
		s->next=p->next;
		p->next=s;
		p=s;
	}
    fclose(fpin);
	return head;
}

pgoods add(char strtype[])
{
	char strname[20]="NULL";
	char str[20]="end";
	pgoods head,p,s;
	FILE *fpin;
	head=p=(pgoods)malloc(sizeof(goods)); 
	head->next=NULL;
	fpin=fopen("a.txt","r+");
	while(!feof(fpin))
	{
		s=(pgoods)malloc(sizeof(goods));
		strcpy(s->name,str);
		s->price=0;
		s->number=0;
		strcpy(s->type,str);
		fscanf(fpin,"%s%f%d%s",&s->name,&s->price,&s->number,&s->type);
		s->next=p->next;
		p->next=s;
		p=s;
	}
	s=(pgoods)malloc(sizeof(goods));
	strcpy(s->name,strname);
	s->price=-1;
	s->number=0;
	strcpy(s->type,strtype);
	s->next=p->next;
	p->next=s;
	p=s;
    fclose(fpin);
	return head;
}

int judgetype(pgoods head,char strtype[])
{
	pgoods p=head->next;
	int temp=1;
	while(p!=NULL)
	{
		if(p->price<0&&strcmp(p->type,strtype)==0)
		{
			temp=-1;
		}
		p=p->next;
	}
	printf("\n");
	return temp;
}


void del(pgoods head,char strtype[])
{
	char str[20]="NULL";
	pgoods q=head,p=head->next;
	while((strcmp(p->name,str)!=0||strcmp(p->type,strtype)!=0)&&p->next!=NULL)
	{
		q=p;
		p=p->next;
	}
	if(p->price>-1)
	{
		printf("\n  您想删除的货物类型不在系统内!\n\n");
	}
	else if((p->number=count(p->type))>0)
	{
		printf("\n  该类型下存在货物，删除操作被禁止！\n\n");
	}
	else
	{
		q->next=p->next;
		free(p);
		printf("\n  删除成功!\n\n");
	}
}

void delname(pgoods head,char strname[])
{
	char str[20]="NULL";
	pgoods q=head,p=head->next;
	while(strcmp(p->name,strname)!=0&&p->next!=NULL)
	{
		q=p;
		p=p->next;
	}
	if(strcmp(p->name,strname)!=0)
	{
		printf("\n  您想删除的货物不在系统内!\n\n");
	}
	else if(p->number>0)
	{
		printf("\n  该货物数量不为零，删除操作被禁止！\n\n");
	}
	else
	{
		q->next=p->next;
		free(p);
		printf("\n  删除成功!\n\n");
	}
}

void outputtype(pgoods head)
{
	pgoods p=head->next;
	int n=1;
	int i=0;
	char str1[20]="end";
	char str2[20]="NULL";
	printf("\tORDER\t\tTYPE\t\tNUMBER\n");
	while(p!=NULL)
	{
		if(strcmp(p->name,str1)!=0&&strcmp(p->name,str2)==0)
		{
			p->number=count(p->type);
			printf("\t  %d\t\t%s",n++,p->type);
			for(i=0;i<16-(int)strlen(p->type);i++)
			{
				printf(" ");
			}
			printf("%d\n",p->number);
		}
		p=p->next;
	}
	printf("\n");
}

int count(char strtype[])
{
	pgoods head,p,s;
	char str[20]="end";
	int n=-1;
	FILE *fpin;
	head=p=(pgoods)malloc(sizeof(goods)); 
	head->next=NULL;
	fpin=fopen("a.txt","r+");
	
	while(!feof(fpin))
	{
		s=(pgoods)malloc(sizeof(goods));
		strcpy(s->name,str);
		s->price=0;
		s->number=0;
		strcpy(s->type,str);
		fscanf(fpin,"%s%f%d%s",&s->name,&s->price,&s->number,&s->type);
		if(strcmp(s->type,strtype)==0)
		{
			n++;
		}
		s->next=p->next;
		p->next=s;
		p=s;
	}
    fclose(fpin);
	return n;
}

void stockoutput(pgoods head,char strgoods[])
{
	pgoods p=head->next;
	int n=1;
	int i=0;
	char str1[20]="end";
	char str2[20]="NULL";
	printf("\n\tORDER\t\tNAME\t\tPRICE\t\tNUMBER\t\tTYPE\n");
	while(p!=NULL)
	{
		if(strcmp(p->name,str1)!=0&&strcmp(p->name,str2)!=0&&strcmp(p->type,strgoods)==0)
		{
			printf("\t  %d\t\t%s",n++,p->name);
			for(i=0;i<16-(int)strlen(p->name);i++)
			{
				printf(" ");
			}
			printf("%.2f\t\t%d\t\t%s\n",p->price,p->number,p->type);
		}
		p=p->next;
	}	
	printf("\n");
}

int judgename(pgoods head,char strname[],char strtype[])
{
	pgoods p=head->next;
	int temp=1;
	while(p!=NULL)
	{
		if(p->price>=0&&strcmp(p->name,strname)==0&&strcmp(p->type,strtype)==0)
		{
			temp=-1;
		}
		if(p->price>=0&&strcmp(p->name,strname)==0&&strcmp(p->type,strtype)!=0)
		{
			temp=-2;
		}
		p=p->next;
	}
	return temp;
}

void goodplus(pgoods head,char strname[],int delta)
{
	pgoods p=head->next;
	while(strcmp(p->name,strname)!=0&&p->next!=NULL)
	{
		p=p->next;
	}
	if(strcmp(p->name,strname)==0)
	{
		p->number+=delta;
	}
}

pgoods addgoods(char strname[],float price,int number,char strtype[])
{
	char str[20]="end";
	pgoods head,p,s;
	FILE *fpin;
	head=p=(pgoods)malloc(sizeof(goods)); 
	head->next=NULL;
	fpin=fopen("a.txt","r+");
	while(!feof(fpin))
	{
		s=(pgoods)malloc(sizeof(goods));
		strcpy(s->name,str);
		s->price=0;
		s->number=0;
		strcpy(s->type,str);
		fscanf(fpin,"%s%f%d%s",&s->name,&s->price,&s->number,&s->type);
		s->next=p->next;
		p->next=s;
		p=s;
	}
	s=(pgoods)malloc(sizeof(goods));
	strcpy(s->name,strname);
	s->price=price;
	s->number=number;
	
	strcpy(s->type,strtype);
	
	s->next=p->next;
	p->next=s;
	p=s;
	printf("\n  货物新增成功！\n\n");
    fclose(fpin);
	return head;
}

void goodreduce(pgoods head,char strname[],int delta)
{
	pgoods p=head->next;
	while(strcmp(p->name,strname)!=0&&p->next!=NULL)
	{
		p=p->next;
	}
	if(strcmp(p->name,strname)==0)
	{
		if(delta>p->number)
		{
			printf("\n  库存不足，出库操作失败！\n\n");
		}
		else
		{
			p->number-=delta;
	    	printf("\n  出库成功！\n\n");
		}
	}
}

void searchname(pgoods head,char strname[])
{
	pgoods p=head->next;
	int i=0;
	int flag=-1;
	char str[20]="end";
	if(strcmp(str,strname)==0)
	{
		flag=-1;
	}
	else
	{
		while(p!=NULL)
		{
			if(p->price>=0&&strcmp(p->name,strname)==0)
			{
				printf("\n\tNAME\t\tPRICE\t\tNUMBER\t\tTYPE\n");
				printf("\t%s",p->name);
				for(i=0;i<16-(int)strlen(p->name);i++)
				{
					printf(" ");
				}
				printf("%.2f\t\t%d\t\t%s\n",p->price,p->number,p->type);
				printf("\n\n");
				flag=1;
			}
			p=p->next;
		}
	}
	if(flag!=1)
	{
		printf("\n  您搜索的货物不在系统内！\n\n");
	}
}

void delempty(pgoods head)
{
	char str[20]="end";
	pgoods q=head,p=head->next;
	while(p->next!=NULL)
	{
		q=head;p=head->next;
		while(strcmp(p->name,str)!=0&&p->next!=NULL)
		{
			q=p;
			p=p->next;
		}
		if(strcmp(p->name,str)==0)
		{
			q->next=p->next;
			free(p);
		}
	}

}

void write(pgoods head)
{
	FILE *fpout;
	pgoods p=head->next;
	fpout=fopen("a.txt","w");
	while(p!=NULL)
	{
		fprintf(fpout,"%s\t%.2f\t%d\t%s\n",p->name,p->price,p->number,p->type);
		p=p->next;
	}
	fclose(fpout);
}

void destroy(pgoods head)
{
	pgoods p,q=head;
	while(q!=NULL)
	{
		p=q;
		q=q->next;
		free(p);
	}
}